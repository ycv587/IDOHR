package com.ido.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ido.bean.Contract;
import com.ido.service.ContractServiceI;
import com.zhuozhengsoft.pageoffice.FileSaver;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;

@Controller
@RequestMapping("/other")
public class OtherController {

	@Autowired
	private ContractServiceI contractServiceI;

	@RequestMapping("/msgshow")
	public String showMessage() {
		return "other/message";
	}

	@RequestMapping("/wordshow")
	public String showWord() {
		return "other/word";
	}

	@RequestMapping("/word")
	public String openbar(HttpServletRequest request, HttpServletResponse response, String conno) {
		// 设置PageOffice服务器组件
		PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
		request.setAttribute("poCtrl1", poCtrl1);
		poCtrl1.setServerPage(request.getContextPath() + "/poserver.zz"); // 此行必须
		poCtrl1.setTitlebar(false); // 隐藏标题栏(pageoffice的标题)
		poCtrl1.setMenubar(false); // 隐藏菜单栏（文件一个设置）
		poCtrl1.setOfficeToolbars(false);// 隐藏Office工具条（word 的编辑按钮）
		// poCtrl1.setCustomToolbar(false);// 隐藏自定义工具栏（保存 关闭 全屏）
		Contract contract = contractServiceI.findByConno(conno);
		String path = contract.getConpath() + "\\" + contract.getConname();
		request.getSession().setAttribute("path", path);
		String suffix = path.substring(path.lastIndexOf(".") + 1);
		if ("doc".equals(suffix) || "docx".equals(suffix)) {
			poCtrl1.webOpen(path, OpenModeType.docReadOnly, "管理员");
		} else if ("xls".equals(suffix) || "xlsx".equals(suffix)) {
			poCtrl1.webOpen(path, OpenModeType.xlsReadOnly, "管理员");
		}
		// 打开文件
		return "other/word";
	}

	/**
	 * 保存
	 * 
	 * @param request
	 * @param response
	 * @param flag
	 */
	@RequestMapping("/savefile")
	public void savefile(HttpServletRequest request, HttpServletResponse response) {
		FileSaver fs = new FileSaver(request, response);
		fs.saveToFile("D:\\eclipse-workspace\\HR\\src\\main\\webapp\\upload\\" + fs.getFileName());
		fs.close();
	}

}
