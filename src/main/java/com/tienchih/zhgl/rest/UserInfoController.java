package com.tienchih.zhgl.rest;

import com.alibaba.fastjson.JSONObject;
import com.tienchih.zhgl.entity.UserInfo;
import com.tienchih.zhgl.service.IUserInfoService;
import com.tienchih.zhgl.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String history() {
        return "history/alarmFolw";
    }

    @GetMapping(value = "/userInfo")
    public String index(Model model) {
        Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = new PageRequest(0, 10, sort);
        Page<UserInfo> userInfoList = userInfoService.queryListByPage(pageable);
        model.addAttribute("userInfoList", userInfoList);
        return "user_mrg";
    }


    @PostMapping(value = "/userInfo")
    @ResponseBody
    public String save(UserInfo userInfo) {
        userInfoService.save(userInfo);
        return "";
    }

    @GetMapping(value = "/delUser")
    @ResponseBody
    public void delete(Integer userInfoId) {
        userInfoService.delete(userInfoId);
    }

    @GetMapping(value = "/userInfo/{id}")
    @ResponseBody
    public UserInfo userInfo(@PathVariable(value = "id") int id) {
        UserInfo userInfo = userInfoService.findById(id);
        return userInfo;
    }

    @PostMapping(value = "/authLogin")
    @ResponseBody
    public JSONObject authLogin(HttpServletRequest request, UserInfo userInfo) {
        HttpSession session = request.getSession();
        JSONObject result = new JSONObject();

        Date now = new Date();
        String user = userInfo.getUserName();
        Const.Login_Auth.put(user,now);
        result.put("success", "true");
        result.put("data", "");

        return result;
    }

    @PostMapping(value = "/doLogin")
    @ResponseBody
    public JSONObject doLogin(HttpServletRequest request, UserInfo userInfo) {
        HttpSession session = request.getSession();
        JSONObject result = new JSONObject();
        UserInfo validate = userInfoService.validate(userInfo.getUserName(), userInfo.getPassword());
        if (validate != null) {
            session.setAttribute("userName", validate.getUserName());

            Date now = new Date();
            Date time = null;
            time = Const.Login_Auth.get(validate.getUserName());
            if(null != time)
            {
                long mills=(now.getTime()-time.getTime())/1000;
                if (mills<=20)
                {
                    result.put("success", "online");
                    result.put("data", "");
                    return result;
                }
            }
            result.put("success", "true");
            result.put("data", validate);
        } else {
            result.put("success", "false");
            result.put("data", "");
        }
        return result;
    }

}