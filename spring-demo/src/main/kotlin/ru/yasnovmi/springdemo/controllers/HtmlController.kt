package ru.yasnovmi.springdemo.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.yasnovmi.springdemo.service.Counter
import java.net.URL


@RestController
class HtmlController {

    @Autowired
    lateinit var counter: Counter

    @RequestMapping("hello")
    fun helloWorld(): String {
        return "hello world!"
    }

    @RequestMapping("new", method = [RequestMethod.GET])
    fun newURL(
            @RequestParam("url")
            url: String
    ): String {
        val uri = URL("https://$url")
        counter.addNew(uri.host.toLowerCase())
        return "ok"
    }

    @RequestMapping("top", method = [RequestMethod.GET])
    fun getTop(): String {
        return counter.getTop().toString()
    }
}
