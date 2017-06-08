package com.wijdemans.error

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

class ErrorsTest extends Specification {

    def "when is serialize Errors i expect intended json"() {
        given:
        Errors e = new Errors(new IllegalArgumentException("wrong input, bad people"))
        ObjectMapper o = new ObjectMapper()

        when:
        def s = o.writeValueAsString(e)

        then:
        s == """{"errors":[{"code":100,"message":"wrong input, bad people","description":""}]}"""
    }
}
