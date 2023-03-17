package com.marondal.megagram.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marondal.megagram.user.bo.UserBO;

@Controller
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	@PostMapping("/signup")
		public Map<String, String>signup(
				@RequestParam("loginId") String loginId
				, @RequestParam("password") String password
				, @RequestParam("name") String name
				, @RequestParam("email") String email
				) {
			
			int count = userBO.addUser(loginId, password, name, email);
			
					//회원가입및 중복 확인기능까지 진행해보기
			Map<String, String>	resultMap = new HashMap<>();
			
			if (count == 1) {
				resultMap.put("result", "success");
			} else {
				resultMap.put("result", "fail");
			}
			return resultMap;
			
			
		}
		
	

}
