package web.digitallibrary.contollers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.digitallibrary.Dao.GenreDAO;
import web.digitallibrary.model.Genre;

@Controller
@RequestMapping("/genres")
public class GenreController {
    private final GenreDAO genreDAO;

    @Autowired
    public GenreController(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("genreList", genreDAO.getAll());
        return "genres/showAll";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model) {
        model.addAttribute("genre", genreDAO.getById(id));
        model.addAttribute("numberOfFollowers", genreDAO.countPeopleForGenre(id));
        return "genres/showById";
    }

    @GetMapping("/new")
    public String add(@ModelAttribute("genre") Genre genre) {
        return "genres/new";
    }

    @PostMapping()
    public String add(@ModelAttribute("genre") @Valid Genre genre, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "genres/new";
        }
        genreDAO.save(genre);
        return "redirect:/genres";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("genre", genreDAO.getById(id));
        return "genres/edit";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("genre") @Valid Genre genre, BindingResult bindingResult,
        @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "genres/edit";
        }
        genreDAO.update(id, genre);
        return "redirect:/genres";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        genreDAO.delete(id);
        return "redirect:/genres";
    }
}
