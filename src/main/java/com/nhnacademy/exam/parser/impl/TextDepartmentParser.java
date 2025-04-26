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

import com.nhnacademy.exam.model.request.DepartmentRequest;
import com.nhnacademy.exam.parser.DepartmentParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TextDepartmentParser implements DepartmentParser {

    @Override
    public String getFileType() {
        return "txt";
    }

    @Override
    public List<DepartmentRequest> parsing(File file) throws IOException {
        List<DepartmentRequest> departmentRequests = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = null;

            while((line = bufferedReader.readLine()) != null) {

                if(line.startsWith("|--")) continue;
                if(line.startsWith("|사번")) continue;

                String[] tokens = line.split("\\|");

                log.info("size:{}", tokens.length);

                String id = tokens[0].trim();
                String name = tokens[1].trim();
                String department = tokens[2].trim();
                String departmentId = tokens[3].trim();

                departmentRequests.add(new DepartmentRequest(id, name, department, departmentId));
            }

        }

        return departmentRequests;
    }
}
