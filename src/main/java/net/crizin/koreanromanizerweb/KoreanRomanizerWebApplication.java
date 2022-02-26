package net.crizin.koreanromanizerweb;

import java.util.Optional;
import net.crizin.KoreanCharacter;
import net.crizin.KoreanRomanizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SpringBootApplication
public class KoreanRomanizerWebApplication {

	@RequestMapping("/")
	public String index(Model model,
			@RequestParam(required = false) String string,
			@RequestParam(required = false) KoreanCharacter.Type type,
			@RequestParam(required = false) KoreanCharacter.ConsonantAssimilation consonantAssimilation) {

		model.addAttribute("type", Optional.ofNullable(type).map(Enum::name).orElse(null));
		model.addAttribute("consonantAssimilation", Optional.ofNullable(consonantAssimilation).map(Enum::name).orElse(null));

		if (string != null && !string.isEmpty()) {
			model.addAttribute("string", string);
			model.addAttribute("romanized", KoreanRomanizer.romanize(string, type, consonantAssimilation));
		}

		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(KoreanRomanizerWebApplication.class, args);
	}
}