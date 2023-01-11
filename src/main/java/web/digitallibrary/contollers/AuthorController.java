package web.digitallibrary.contollers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.digitallibrary.DAO.AuthorDAO;
import web.digitallibrary.DAO.GenreDAO;
import web.digitallibrary.model.Author;
import web.digitallibrary.model.Genre;
import web.digitallibrary.util.GenreValidator;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorDAO authorDAO;

    @Autowired
    public AuthorController(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("authorList", authorDAO.getAll());
        return "authors/showAll";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model) {
        model.addAttribute("author", authorDAO.getById(id));
        return "authors/showById";
    }

    @GetMapping("/new")
    public String add(@ModelAttribute("author") Author author) {
        return "authors/new";
    }

    @PostMapping()
    public String add(@ModelAttribute("author") @Valid Author author, BindingResult bindingResult) {
//        genreValidator.validate(genre, bindingResult);
        if (bindingResult.hasErrors()) {
            return "authors/new";
        }
        authorDAO.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("author", authorDAO.getById(id));
        return "authors/edit";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("genre") @Valid Author author, BindingResult bindingResult,
                       @PathVariable("id") int id) {
//        genreValidator.validate(genre, bindingResult);
        if (bindingResult.hasErrors()) {
            return "authors/edit";
        }
        authorDAO.update(id, author);
        return "redirect:/authors";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        authorDAO.delete(id);
        return "redirect:/authors";
    }
}
