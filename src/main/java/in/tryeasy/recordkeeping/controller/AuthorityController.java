package in.tryeasy.recordkeeping.controller;


import in.tryeasy.recordkeeping.model.authority.AuthorityCreateRequest;
import in.tryeasy.recordkeeping.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class AuthorityController {

    private final AuthorityService authorityService;

    @GetMapping("/authorities")
    public String getCreateAuthorityPage(Model model) {
        model.addAttribute("authorityCreateRequest", AuthorityCreateRequest.builder().build());
        return "/authority/authorities";
    }

    @PostMapping("/authorities")
    public String addAuthority(Model model, AuthorityCreateRequest request) {
        final var response = this.authorityService.addAuthority(request);
        model.addAttribute("authorityCreateResponse", response);
        return "/authority/authorities";
    }

    @PostMapping("/authorities/upload")
    public String uploadAuthority(Model model, AuthorityCreateRequest request, @RequestParam("file") MultipartFile file) {
        final var response = this.authorityService.uploadAuthority(file);
        model.addAttribute("authorityUploadResponse", response);
        model.addAttribute("authorityCreateRequest", AuthorityCreateRequest.builder().build());
        return "/authority/authorities";
    }

}
