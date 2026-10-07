
document.addEventListener("DOMContentLoaded", function () {

    const role =
        localStorage.getItem("userRole");

    const username =
        localStorage.getItem("username");



    if (!role) {

        window.location.href = "/index.html";

        return;

    }




    const loggedInUser =
        document.getElementById("loggedInUser");


    if (loggedInUser) {

        if (role === "ADMIN") {

            loggedInUser.innerText = "Admin";

        }
        else if (role === "EMPLOYEE") {

            loggedInUser.innerText = "Employee";

        }

    }

    // dashboardLinks

    const dashboardLinks =
        document.querySelectorAll(
            'a[href="dashboard.html"], a[href="emp-dashboard.html"]'
        );


    dashboardLinks.forEach(function (link) {

        if (role === "ADMIN") {

            link.href =
                "dashboard.html";

        }
        else if (role === "EMPLOYEE") {

            link.href =
                "emp-dashboard.html";

        }

    });


    // =================================================
    // PROTECT DASHBOARD PAGES
    // =================================================

    const currentPage =
        window.location.pathname;


    // Employee should not stay on Admin dashboard

    if (
        role === "EMPLOYEE" &&
        currentPage.endsWith("/dashboard.html")
    ) {

        window.location.href =
            "/emp-dashboard.html";

        return;

    }


    // Admin should not stay on Employee dashboard

    if (
        role === "ADMIN" &&
        currentPage.endsWith("/emp-dashboard.html")
    ) {

        window.location.href =
            "/dashboard.html";

        return;

    }


    // =================================================
    // VENDOR PAYMENT
    // =================================================

    const vendorPaymentMenu =
        document.getElementById(
            "vendorPaymentMenu"
        );


    if (
        vendorPaymentMenu &&
        role === "EMPLOYEE"
    ) {

        vendorPaymentMenu.style.display =
            "none";

    }


    const employeePaymentMenu =
        document.getElementById(
            "employeePaymentMenu"
        );


    if (
        employeePaymentMenu &&
        role === "EMPLOYEE"
    ) {

        employeePaymentMenu.style.display =
            "none";

    }

});