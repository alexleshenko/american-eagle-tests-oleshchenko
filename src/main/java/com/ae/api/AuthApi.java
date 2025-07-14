package com.ae.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthApi {

    public static String getAccessToken() {
        Response response = given()
                .baseUri("https://www.ae.com")
                .basePath("/ugp-api/auth/oauth/v5/token")
                .header("authorization", "Basic MjBlNDI2OTAtODkzYS00ODAzLTg5ZTctODliZmI0ZWJmMmZlOjVmNDk5NDVhLTdjMTUtNDczNi05NDgxLWU4OGVkYjQwMGNkNg==")
                .header("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("origin", "https://www.ae.com")
                .header("referer", "https://www.ae.com/us/en")
                //.header("Cookie", "TLTUID=47DF568FD7853DA437074CF1754BD26F; akaalb_PROD_ALB=~op=PROD_LB_ALL_DCs:PROD_LB_Origin_East4_AGWA_Service_Mesh|~rv=84~m=PROD_LB_Origin_East4_AGWA_Service_Mesh:0|~os=db0ecb8ead961a2983478ea211c488b6~id=8ab3ba5c3be9d604a9b550a6d0c590eb; bm_sz=14D4EAB22F03E9E772B46D542BC7670B~YAAQVBczFyCBv6CXAQAArzmbwRylnT4yGB6MqFT0RgYOHatFlaXvJ1sBtCEDeWEuiXqmGtv7VnDP2cDV/EiHXUf+V1xZ0vW7HJ1OLjLW8V0ioJRKSPHZri44BuoCzvUTRfGjjlKMxJerXoua0PO2pvUWmFILdj2GxDSRNeyysLSZVy4iATeXqwiF7u7IQVrvp+U6NmeMqtb6RYFtGxr4Z14ruqKfID6KQx9CYxuYe/KqtKSU3kwRssEiFWCjv7DXkANEtnAp85xx9cMiRIpFxB6pcv+Rs1rKYkfjPci7JFlXMeLACJd2XSMbJGNAnfG/EOxZxV0oMXDF2bPIu4rD2p8EiS9+VH6zUeM6hhJuOEslUWpBT7Wo3T+vUAbkO9wdt4VzrwYtu/iW6g==~3621937~3617840; optimizelyEndUserId=oeu1751299865481r0.37824427414871875; _abck=A2E7F9F62011EA0A9924E0F2FF7E3B12~-1~YAAQVBczFy2Ev6CXAQAAOj+bwQ6WGkjZkf5gx1W5PV6CZ3YBf5TkQMbBOv7do9EQrnneYaaQRWZInTxEgEuMd4ZwNKKxTPyWpAMtgC9gLREDXLbMmeN8EusrYlb3vGwQ03QQ/xS/0OJhT4phyGFEJO8D1kReFDpYFu46rfqGfwkJSaElkalmBZ4dT7toamLmjAZyiR7r5c9bOw7Zn0j+XE+4eZJd6LosRGW1bTGGf0n9OhCjWbv7Z+Jix5KV+7P62LxNxCAXkkzkkn5a1HdMWgbHGFpApRJeGaYEE8yVvgbPjNv4aukELJc61CG8N9aBdcU88xZmFgxnp8SEWsbngDbifbG0iNVjuJ6RmSvgTyBOo2ppWcWvks5o/AdzDuhoARu8QiIommEBh3UH65njzhv/+P5Gd+XpKkh/R2rQnEmGnL7zPNv4Uf29i6fXPipNMCGwxKdqAzS8AjMlVaB+mZALCf7TjATA4J2vUd6Oz6r9cThfkd7GnUZl6no0FATZ6qgf75O8BmGuCmf8Yx70Ck89caP6vXpR3Hkjscz7EP6wEPaXdwQocSOPuhyEz8siNvZ7O9bOMMTGjjCt4xXzQj8YFb0z7XwRZf0=~-1~||0||~-1; c_uuid=2501006464537361380005373651080192024; brand=aeo; ak_bmsc=0E8F3C18CD99698D460D15E3724FB17B~000000000000000000000000000000~YAAQVBczF7OFv6CXAQAA4kGbwRzrDaGdfLE7rdhAmmyli0qC0FYb+udTmUCsn2kfF/X4wDTI/9XqTQaZkdl8NOjz8mTRkcby1/qMc2nAP/7ao6FZ4yDO+ZB2xJxE75aP9rEZEB/N+ImAnZL0Sr9rI4xlQJKHiAUdQOuX89zw0WyJYBVNa2mBP6MjlSSRwUW6J5/0G9no7BI2oNHyMRMis/PN4otGixlJvKgzXnTSjgj765cma/Y5yFPcafKdTyiJ/AIti4wtfxQIUmszgnveWCCNKRFo4z4Qut39fPKIHpdSE2qgtZR4cmvAgX5D5AeyiqRaZzCrCSkyru5mj0VwTBXpFR6WZDIZpST4Q1/zS1vIlAucah3Ly1BgVgHRgVJPiPBr883VofgA3tVhRqjo1pnX6YSdSlXWIeAAzFZMxhb/+3A1zUZ+IiaMFqJWDTEJ/bgu4Cvq3Ic=; bm_sv=571E4A10BCF11A751887AE56D18E4383~YAAQVBczFwOGv6CXAQAAakKbwRx7xvznN3S6RKiPyt3OunbYUIF4Vawxd+9QjvD1DoPySZLv5xaIXPYAhs7B7OD2TfM0cfcMArBSyYLWk0u1+3l3UTcBN8l8aUSiNTjVpbeav/soruw3UG8PmTGOi617Ms7rbdG/1dpIcT+ShBtlYoMx4zEf+lVQHTcfGtUYd00GohLhvCyySdv1+9P9/iu5Vw6dFbeLOjhi6OVJQDnhXqKhdOCMj6N5Eck=~1")
                .formParam("grant_type", "client_credentials")
                .log().all()
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        return response.jsonPath().getString("access_token");
    }
}
