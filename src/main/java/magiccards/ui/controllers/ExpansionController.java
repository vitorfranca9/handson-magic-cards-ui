package magiccards.ui.controllers;

import magiccards.ui.entities.Card;
import magiccards.ui.entities.Expansion;
import magiccards.ui.entities.Page;
import magiccards.ui.entities.TablePage;
import magiccards.ui.proxies.ExpansionFacadeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExpansionController {

    @Autowired
    private ExpansionFacadeProxy expansionProxy;

    @RequestMapping(value="/expansions", method = RequestMethod.GET)
    public String list() {

        return "expansions/list";
    }

    @RequestMapping(value="/expansions/data", method = RequestMethod.GET)
    public @ResponseBody
    TablePage<Expansion> listPaged(@RequestParam("draw")int draw, @RequestParam("start")int start, @RequestParam("length")int length) {

        int pageNumber = (start/length) + 1;
        Page<Expansion> expansions = expansionProxy.getExpansions(pageNumber, length);

        TablePage<Expansion> result = new TablePage<Expansion>();
        result.setData(expansions.getContent());
        result.setRecordsTotal(expansions.getTotalElements());
        result.setRecordsFiltered(expansions.getTotalElements());
        result.setDraw(draw);
        return result;
    }

    @RequestMapping(value="/expansions/create", method = RequestMethod.GET)
    public String create() {
        return "expansions/create";
    }

    @RequestMapping(value="/expansions/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id")String id, Model model) {

        Expansion expansion = expansionProxy.getExpansionId(id);
        model.addAttribute("expansion", expansion);
        return "expansions/update";
    }

    @RequestMapping(value="/cards/create", method = RequestMethod.POST)
    public String create(Expansion expansion) {

        expansionProxy.create(expansion);

        return "redirect:/cards";
    }

    @RequestMapping(value="/cards/update", method = RequestMethod.POST)
    public String update(Expansion expansion) {

        expansionProxy.update(expansion);

        return "redirect:/cards";
    }

    @RequestMapping(value="/cards/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id")String id) {

        expansionProxy.delete(id);

        return "redirect:/expansions";
    }


}
