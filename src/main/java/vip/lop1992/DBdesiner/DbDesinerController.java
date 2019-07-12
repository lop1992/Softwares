package vip.lop1992.DBdesiner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import vip.lop1992.DBdesiner.bean.DbDesinerBean;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class DbDesinerController {

    @Autowired
    DbDesinerDao dao ;

    @GetMapping("/DBDesiner")
    public ModelAndView main(){
         return new ModelAndView("projects/DBDesigner/dbList");
    }

    @ResponseBody
    @PostMapping("/DBDesiner/index")
    public List<DbDesinerBean> indexs(){
        return dao.findIndex();
    }

    @GetMapping("/DBDesiner/edit")
    public ModelAndView main(Long id){
        ModelAndView m = new ModelAndView("projects/DBDesigner/index");
        if(null != id){
            m.addObject("getId",id);
        }
        return m;
    }


    @PostMapping("/DBDesiner/get")
    @ResponseBody
    public DbDesinerBean get(Long id ){

        if(id == null){
            return null;
        }
        Optional<DbDesinerBean> o= dao.findById(id);
        return o.isPresent()?o.get():null;
    }

    @PostMapping("/DBDesiner/save")
    @ResponseBody
    public String save(@RequestBody DbDesinerBean m){
        m.setCreTime(new Date());
        dao.save(m);
        return "{code:1}";
    }
}
