package com.springboot.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboot.entity.TUser;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    /**
     *根据条件查询用户信息
     * @param kw 查询关键字即条件
     * @param model 模型对象，也是视图（界面）的上下文环境对象
     * @param pageable 分页信息对象，包含了分页需要的基本信息，如当前页码，每页需要的数据
     * @return 字符串，代表了界面文件
     */
    @GetMapping("/listusers")
    public String listall(String kw, Model model, Pageable pageable){
        model.addAttribute("kw",kw);
        if (kw!=null) kw="%"+kw+"%";
        if (kw==null) kw="%%";
        Page<TUser> ppu=userService.findAll(kw, pageable);//默认分页从0页面（第一页），取每页20条数据
        model.addAttribute("pages",ppu);
        return "listusers";//返回界面
    }
    @PostMapping("/listusers")
    public String listuserbykw(String kw, Model model, Pageable pageable){
        model.addAttribute("kw",kw);
        if (kw!=null) kw="%"+kw+"%";
        if (kw==null) kw="%%";
        Page<TUser> ppu=userService.findAll(kw, pageable);//默认分页从0页面（第一页），取每页20条数据
        model.addAttribute("pages",ppu);
        return "listusers";//返回界面
    }

    @GetMapping({"/edituser","/edituser/{id}"})
    public String edit(@PathVariable(name="id",required = false)Integer id, Model model) {
        TUser u = new TUser();
        if (id != null && id > 0) {
            u = userService.findById(id);
        }
        model.addAttribute("sexes",TUser.Sex.toList());
        model.addAttribute("user", u);
        return "edituser";
    }

    @GetMapping("/deleteuser/{id}")
    public String delete(@PathVariable("id")Integer id){
        userService.deleteById(id);
        return "redirect:/listusers";
    }

    @PostMapping("/deleteusers")
    public String deletes(String ids){
        System.out.println("======"+ids);
        List<TUser> users=new ArrayList<>();
        JSONObject json=JSONObject.parseObject(ids);
        JSONArray arr=json.getJSONArray("ids");//前端传递时使用uods作为json数据的键
        int ilen=arr.size();
        for (int i=0;i<ilen;i++){//每次循环ilen次来执行ilen个查询，再去删除
            users.add(userService.findById(arr.getInteger(i)));
        }
        userService.deletes(users);
        return "redirect:/listusers";
    }

}




