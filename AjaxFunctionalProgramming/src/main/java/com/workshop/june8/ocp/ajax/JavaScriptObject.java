package com.workshop.june8.ocp.ajax;

public record JavaScriptObject(
        String url,
        String type,
        String dataType,
        AjaxFunction<String> succes,
        AjaxFunction<String> fail){}

//          $.ajax({
//                url: api,
//                type: "get",
//                dataType: "json",
//                async: false,
//                success: customers =>{
//
//                console.log('Data: ' + customers );
//
//                if (customers) {
//                    customerTable.clear();
//                    customerTable.rows.add(customers);
//                    customerTable.columns.adjust().draw();
//               }
//            },
//
//            fail: function (error) {
//                console.log('Error: ' + error);
//            }
//        });
