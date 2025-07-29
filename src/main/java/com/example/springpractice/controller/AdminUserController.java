package com.example.springpractice.controller;

import java.util.List;

import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springpractice.entity.User;
import com.example.springpractice.form.UserRegisterForm;
import com.example.springpractice.service.UserService;

@Controller
public class AdminUserController {
	private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/adminuser")
    public String adminUser(Model model) {
        // 最新のユーザーリストを取得
        List<User> users = userService.getAllUsers();

        // ビューにユーザーリストを渡す
        model.addAttribute("users", users);
        
        //すでにインスタンスが存在する場合は行わない
        if(!model.containsAttribute("userRegisterForm")) {
        	//ビューにフォームクラスのインスタンスを渡す
        	model.addAttribute("userRegisterForm", new UserRegisterForm());
        }
        
        return "adminUserView";
    }
    
    @PostMapping("/register")
    public String registerUser(RedirectAttributes redirectAttributes,
    		@Validated UserRegisterForm form, BindingResult result) {
    		//UserRegisterForm form) {
            //@RequestParam("user_name") String userName,
            //@RequestParam("password") String password,
            //@RequestParam("role_id") int roleId) {
    	
    	//バリデーションエラーがあったら終了
    	if (result.hasErrors()) {
    		//フォームクラスをビューに受け渡す
    		redirectAttributes.addFlashAttribute("userRegisterForm", form);
    		//バリデーション結果をビューに受け渡す
    		redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX
    				+ Conventions.getVariableName(form), result);
    		
    		//adminuserにリダイレクトしてリストを再表示
    		return "redirect:/adminuser";
    	}
    	
        try {
            // リクエストパラメータからのデータを用いてユーザー登録
        	userService.createUser(form.getUserName(), form.getPassword(), form.getRoleId());
            //userService.createUser(userName, password, roleId);

            // 登録成功時は完了メッセージをビューに受け渡す
            redirectAttributes.addFlashAttribute("successMessage", "ユーザー登録が完了しました。");

        } catch (IllegalArgumentException e) {
            // 登録失敗時はエラーメッセージをビューに受け渡す
            redirectAttributes.addFlashAttribute("failureMessage", e.getMessage());
            
            //フォームクラスをビューに受け流す
            redirectAttributes.addFlashAttribute("userRegisterForm", form);
            // 再表示用の入力データをビューに受け渡す（パスワードは除く）
            //redirectAttributes.addFlashAttribute("userName", userName);
            //redirectAttributes.addFlashAttribute("roleId", roleId);
        }

        // adminuserにリダイレクトしてリストを再表示
        return "redirect:/adminuser";
    }
}
