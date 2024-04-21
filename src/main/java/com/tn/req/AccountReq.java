package com.tn.req;

import lombok.Data;

@Data
public class AccountReq {
    private String fullName;

    private String username;

    private String password;

    private String email;
}
