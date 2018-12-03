package com.nf147.post.posc;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nf147.post.dao.PostMapper;
import com.nf147.post.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class PostList  {

    @Autowired
    private PostMapper postMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String home(@RequestParam(defaultValue = "1") int page, Model model) {
        PageHelper.startPage(page, 2);
        List<Post> posts = postMapper.selectAll();
        model.addAttribute("posts", posts);
        model.addAttribute("pageInfo", new PageInfo<>(posts));
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(Post post) {
        postMapper.insert(post);
        return "redirect:/";
    }


    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delete (@PathVariable("id") int id) {
    postMapper.deleteByPrimaryKey(id);
        return "redirect:/";
    }
}
