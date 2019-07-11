package vip.lop1992.mind;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vip.lop1992.mind.bean.MyMind;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class MyMindController {

    @Autowired
    MyMindDao dao ;

    @GetMapping("/mind")
    public ModelAndView main(){
         return new ModelAndView("projects/my_mind/myMindList");
    }

    @ResponseBody
    @PostMapping("/mind/index")
    public List<MyMind> indexs(){
        return dao.findIndex();
    }

    @GetMapping("/mind/edit")
    public ModelAndView main(Long id){
        ModelAndView m = new ModelAndView("projects/my_mind/index");
        if(null != id){
            m.addObject("getId",id);
        }
        return m;
    }


    @PostMapping("/mind/get")
    @ResponseBody
    public MyMind get(Long id ){

        if(id == null){
            return null;
        }
        Optional<MyMind> o= dao.findById(id);
        return o.isPresent()?o.get():null;
    }

    @PostMapping("/mind/save")
    @ResponseBody
    public String save(@RequestBody MyMind m){
        m.setCreTime(new Date());
        dao.save(m);
        return "{code:1}";
    }
}
