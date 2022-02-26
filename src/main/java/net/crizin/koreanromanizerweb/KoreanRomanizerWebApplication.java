package net.crizin.koreanromanizerweb;

import net.crizin.KoreanCharacter;
import net.crizin.KoreanRomanizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class KoreanRomanizerWebApplication {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@ResponseBody
	@PostMapping("/")
	public String romanize(@RequestParam String string,
			@RequestParam(required = false) KoreanCharacter.Type type,
			@RequestParam(required = false) KoreanCharacter.ConsonantAssimilation consonantAssimilation) {
		return KoreanRomanizer.romanize(string, type, consonantAssimilation);
	}

	public static void main(String[] args) {
		SpringApplication.run(KoreanRomanizerWebApplication.class, args);
	}
}