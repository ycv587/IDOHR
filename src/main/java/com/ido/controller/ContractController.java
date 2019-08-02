package com.ido.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ido.bean.Contract;
import com.ido.service.ContractServiceI;

@Controller
@RequestMapping("/contract")
public class ContractController {

	private String Conno = "";

	@Autowired
	private ContractServiceI contractServiceI;

	@RequestMapping("/showall")
	public String showContract() {
		return "other/contract";
	}

	@RequestMapping("/cge")
	public @ResponseBody String change(String conno) {
		Conno = conno;
		return "1";
	}

	/**
	 * 查询所有合同编号和名称
	 * 
	 * @return
	 */
	@GetMapping("/findnameandno")
	public @ResponseBody Object findAllContractNameAndNo() {
		return contractServiceI.findAllContractNameAndNo();
	}

	/**
	 * 文件上传功能
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload")
	public @ResponseBody String upload(MultipartFile file, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		File dir = new File(path, fileName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		Contract contract = new Contract();
		contract.setConflag(1);
		contract.setConname(fileName);
		contract.setConpath(path);
		String result = contractServiceI.addContract(contract);
		if (result != "0") {
			// MultipartFile自带的解析方法
			try {
				file.transferTo(dir);
				return result;
			} catch (IllegalStateException | IOException e) {
				return "-1";
			}
		} else {
			return "0";
		}
	}

	/**
	 * 文件下载功能
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	@RequestMapping("/down")
	public void down(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Contract contract = contractServiceI.findByConno(Conno);
		// 模拟文件，myfile.txt为需要下载的文件
		String fileName = contract.getConpath() + "/" + contract.getConname();
		// 获取输入流
		InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
		// 假如以中文名下载的话
		String filename = contract.getConname();
		// 转码，免得文件名中文乱码
		filename = URLEncoder.encode(filename, "UTF-8");
		// 设置文件下载头
		response.addHeader("Content-Disposition", "attachment;filename=" + filename);
		// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
		response.setContentType("multipart/form-data");
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		int len = 0;
		while ((len = bis.read()) != -1) {
			out.write(len);
			out.flush();
		}
		out.close();
	}
}
