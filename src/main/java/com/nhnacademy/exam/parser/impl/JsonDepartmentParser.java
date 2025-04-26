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

package com.nhnacademy.exam.parser.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.exam.model.request.DepartmentRequest;
import com.nhnacademy.exam.parser.DepartmentParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
public class JsonDepartmentParser implements DepartmentParser {

    private final ObjectMapper objectMapper;

    @Override
    public boolean matchFileType(String fileName){
        return fileName.trim().toLowerCase().endsWith(getFileType().toLowerCase());
    }

    @Override
    public String getFileType() {
        return "json";
    }

    @Override
    public List<DepartmentRequest> parsing(File file) throws IOException {

        return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, DepartmentRequest.class));
    }

}
