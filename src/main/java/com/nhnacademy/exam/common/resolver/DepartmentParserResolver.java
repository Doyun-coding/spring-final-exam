/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2024. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package com.nhnacademy.exam.common.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.exam.exception.NotRequestExtensionException;
import com.nhnacademy.exam.parser.DepartmentParser;
import com.nhnacademy.exam.parser.impl.CsvDepartmentParser;
import com.nhnacademy.exam.parser.impl.JsonDepartmentParser;
import com.nhnacademy.exam.parser.impl.TextDepartmentParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DepartmentParserResolver {

    private final List<DepartmentParser> departmentParserList;

    public DepartmentParser getDepartmentParser(String fileName){
        int index = 0;

        for(int i = fileName.length()-1; i >= 0; i--) {
            if(fileName.charAt(i) == '.') {
                index = i;
                break;
            }
        }

        String extension = fileName.substring(index+1);
        if(!extension.equals("txt") && !extension.equals("json") && !extension.equals("csv")) {
            return null;
        }

        if(extension.equals("txt")) {
            return new TextDepartmentParser();
        }

        if(extension.equals("csv")) {
            return new CsvDepartmentParser();
        }

        return new JsonDepartmentParser(new ObjectMapper());
    }

}
