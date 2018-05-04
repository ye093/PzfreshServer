package cn.yejy.controller;

import cn.yejy.data.ResponseData;
import cn.yejy.service.MemberService;
import cn.yejy.util.JwtTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthorizeController {
    @Autowired
    JwtTokenHelper tokenHelper;
    @Autowired
    MemberService memberService;

    @PostMapping(value = "/authorize/base")
    public ResponseEntity authorize(@RequestParam("mobile") String mobile, @RequestParam("password") String password) {
        Map<String, Object> user = memberService.findUserByMobile(mobile);
        if (user == null || !user.get("password").equals(password)) {
            return ResponseData.error(403, "认证失败");
        }
        // 认证通过
        String token = tokenHelper.getToken(user);
        return ResponseData.ok("success", token);
    }
}
