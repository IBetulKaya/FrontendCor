package controller;

import model.Visitor;
import service.VisitorService;

@Controller
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/enter")
    public String enterNarnia(Visitor visitor){
        if(visitorService.countInsideVisitors()<5){
            visitor.setInside(true);
            visitorService.saveVisitor(visitor);
        }
        return " visitor redirect:/";
    }

    @PostMapping("/exit")

    public String exitNarnia(Long visitorId){
        Visitor visitor = visitorService.getVisitorById(visitorId);
        if(visitor != null){
            visitor.setInside(false);
            visitorService.saveVisitor(visitor);
        }
        return "visitor redirect!";
    }
}
