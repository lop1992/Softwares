package vip.lop1992.markdowngenerate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import vip.lop1992.TreeBeans.TreeVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lop1992
 * @Date: 2019/4/4 9:27
 * 毕竟写代码才不花钱啊
 **/
@Controller
public class MarkDownEditController {
    @Autowired
    MarkDownDao dao;
    @Value("${markDown.EditPwd}")
    String editPwd;

    @GetMapping("/markDown")
    public ModelAndView md_list(){
        return new ModelAndView("md/md_list");
    }


    @PostMapping("/markDown/init")
    @ResponseBody
    public List<TreeVo> md_list_data(){
        List<TreeVo> s= new ArrayList<>();
        ites(dao.findIdNameBypid(0),s,0);
        System.out.println(s);
        return s;
    }


    private List<TreeVo> ites(List<MarkDown> ms ,List<TreeVo> s,int deep){
        if(deep > 1000) {return null;};
        List<TreeVo> s2 = null;
        for (MarkDown m:
        ms) {
            TreeVo t = new TreeVo();
            t.setValue(String.valueOf(m.getId()));
            t.setText(m.getName());
            t.setChildren(ites(dao.findIdNameBypid(m.getId()),s,++deep));
            if(m.getPid() == 0){
                t.setIcon("");
                s.add(t);
            }

            if(s2 ==null){
                s2 =new ArrayList<>();
            }

            s2.add(t);
        }
        return s2;
    }

    @GetMapping("/markDown/indexof")
    public ModelAndView index(String id,String pwd){
        ModelAndView view = new ModelAndView();
        if (id == null){
            view.setViewName("md/md_list");
            view.addObject("mds",dao.findAll());
        }else{
            view.addObject("md",dao.getOne(Long.valueOf(id)));
            if(editPwd.equals(pwd)){
                view.setViewName("md/md_edit");
            }else{
                view.setViewName("md/md_view");
            }
        }
        return view;
    }
    @RequestMapping("/markDown/SaveMarkDown")
    @ResponseBody
    public String SaveMarkDown(MarkDown down){
        try{
            if(down.getId()==null ||  (down.getId()!=2 && down.getId()!=1)){
                if(down.getId() != null){
                    MarkDown old=dao.findById(down.getId()).get();
                    down.setPid(old.getPid());
                }
                dao.save(down);
            }
        }catch (Exception e){
            e.printStackTrace();
            return "{code:0}";
        }

        return "{code:1}";
    }

    @DeleteMapping("/markDown/delMarkDown")
    @ResponseBody
    public String del(MarkDown down,String pwd){
        try{
            if(editPwd.equals(pwd)){
                dao.delete(down);
            }
        }catch (Exception e){
            e.printStackTrace();
            return "{code:0}";
        }

        return "{code:1}";
    }

}
