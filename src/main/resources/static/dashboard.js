

function logout() {

    let confirmLogout =
        confirm("Are you sure you want to logout?");


    if (confirmLogout) {

        // Clear login information
        localStorage.removeItem("userRole");
        localStorage.removeItem("username");

        window.location.href = "/index.html";

    }

}



const addEnquiryButton =
    document.getElementById("add_enquiry");


if (addEnquiryButton) {

    addEnquiryButton.addEventListener(
        "click",
        function () {

            window.location.href =
                "/enquiry.html";

        }
    );

}



// =====================================================
// ENQUIRY MENU
// =====================================================

const enquiryMenu =
    document.getElementById("enquiry");


if (enquiryMenu) {

    enquiryMenu.addEventListener(
        "click",
        function () {

            window.location.href =
                "/allenquiry.html";

        }
    );

}



// =====================================================
// VIEW ALL ENQUIRIES
// =====================================================

const viewAllButton =
    document.getElementById(
        "viewAllEnquiries"
    );


if (viewAllButton) {

    viewAllButton.addEventListener(
        "click",
        function () {

            window.location.href =
                "/allenquiry.html";

        }
    );

}



// =====================================================
// ADD FOLLOW UP
// =====================================================

const addFollowUpButton =
    document.getElementById(
        "addFollowUp"
    );


if (addFollowUpButton) {

    addFollowUpButton.addEventListener(
        "click",
        function () {

            window.location.href =
                "/followUp.html";

        }
    );

}



async function loadTotalEnquiries() {

    try {

        const response =
            await fetch(
                "/skyline/dashboard/enquiry"
            );


        if (!response.ok) {

            throw new Error(
                "Failed to fetch enquiries"
            );

        }


        const enquiries =
            await response.json();


        const countElement =
            document.getElementById(
                "count_enquiry"
            );


        if (countElement) {

            countElement.innerText =
                enquiries.length;

        }

    }
    catch (error) {

        console.error(
            "Error loading enquiries:",
            error
        );


        const countElement =
            document.getElementById(
                "count_enquiry"
            );


        if (countElement) {

            countElement.innerText =
                "0";

        }

    }

}

async function loadTotalFollowUps() {

    try {

        const response =
            await fetch(
                "/skyline/dashboard/followup"
            );


        if (!response.ok) {

            throw new Error(
                "Failed to fetch follow ups"
            );

        }


        const followUps =
            await response.json();


        const countElement =
            document.getElementById(
                "count_followup"
            );


        if (countElement) {

            countElement.innerText =
                followUps.length;

        }

    }
    catch (error) {

        console.error(
            "Error loading follow ups:",
            error
        );


        const countElement =
            document.getElementById(
                "count_followup"
            );


        if (countElement) {

            countElement.innerText =
                "0";

        }

    }

}



// =====================================================
// LOAD SITE VISITS
// =====================================================
//
// Site Visit is calculated from enquiries
// where enquiryType = "Site Visit"
// =====================================================

async function loadTotalSiteVisits() {

    try {

        const response =
            await fetch(
                "/skyline/dashboard/enquiry"
            );


        if (!response.ok) {

            throw new Error(
                "Failed to fetch enquiries"
            );

        }


        const enquiries =
            await response.json();


        const siteVisits =
            enquiries.filter(
                function (enquiry) {

                    return (
                        enquiry.enquiryType ===
                        "Site Visit"
                    );

                }
            );


        const countElement =
            document.getElementById(
                "count_sitevisit"
            );


        if (countElement) {

            countElement.innerText =
                siteVisits.length;

        }

    }
    catch (error) {

        console.error(
            "Error loading site visits:",
            error
        );


        const countElement =
            document.getElementById(
                "count_sitevisit"
            );


        if (countElement) {

            countElement.innerText =
                "0";

        }

    }

}



// =====================================================
// LOAD TOTAL FLAT SALES
// =====================================================

async function loadTotalFlatSales() {

    try {

        const response =
            await fetch(
                "/skyline/dashboard/flatsale"
            );


        if (!response.ok) {

            throw new Error(
                "Failed to fetch flat sales"
            );

        }


        const flatSales =
            await response.json();


        const countElement =
            document.getElementById(
                "count_flatsale"
            );


        if (countElement) {

            countElement.innerText =
                flatSales.length;

        }

    }
    catch (error) {

        console.error(
            "Error loading flat sales:",
            error
        );


        const countElement =
            document.getElementById(
                "count_flatsale"
            );


        if (countElement) {

            countElement.innerText =
                "0";

        }

    }

}



// =====================================================
// LOAD RECENT ENQUIRIES
// =====================================================

async function loadRecentEnquiries() {

    const tableBody =
        document.getElementById(
            "recentEnquiries"
        );


    // Admin dashboard does not have
    // Recent Enquiries section.
    //
    // So simply stop if the element
    // does not exist.

    if (!tableBody) {

        return;

    }


    try {

        const response =
            await fetch(
                "/skyline/dashboard/enquiry"
            );


        if (!response.ok) {

            throw new Error(
                "Failed to fetch enquiries"
            );

        }


        const enquiries =
            await response.json();


        // =============================================
        // SORT
        // Latest enquiry first
        // =============================================

        enquiries.sort(
            function (a, b) {

                return b.id - a.id;

            }
        );


        // =============================================
        // GET LATEST 4
        // =============================================

        const recent =
            enquiries.slice(0, 4);


        // =============================================
        // NO DATA
        // =============================================

        if (recent.length === 0) {

            tableBody.innerHTML = `

                <tr>

                    <td
                        colspan="4"
                        class="text-center text-muted">

                        No enquiries found.

                    </td>

                </tr>

            `;

            return;

        }


        // =============================================
        // CLEAR OLD DATA
        // =============================================

        tableBody.innerHTML = "";



        // =============================================
        // DISPLAY ENQUIRIES
        // =============================================

        recent.forEach(
            function (enquiry) {


                let statusClass =
                    "status-new";


                let statusText =
                    enquiry.enquiryType ||
                    "New";



                // =====================================
                // FOLLOW UP
                // =====================================

                if (
                    enquiry.enquiryType ===
                    "Follow Up"
                ) {

                    statusClass =
                        "status-followup";

                }



                    // =====================================
                    // SITE VISIT
                // =====================================

                else if (
                    enquiry.enquiryType ===
                    "Site Visit"
                ) {

                    statusClass =
                        "status-sitevisit";

                }



                    // =====================================
                    // BOOKING
                // =====================================

                else if (
                    enquiry.enquiryType ===
                    "Booking"
                ) {

                    statusClass =
                        "status-booked";

                }



                // =====================================
                // CREATE ROW
                // =====================================

                const row =
                    document.createElement(
                        "tr"
                    );


                row.innerHTML = `

                    <td>
                        ${enquiry.customerName || "-"}
                    </td>

                    <td>
                        ${enquiry.mobile || "-"}
                    </td>

                    <td>
                        ${enquiry.flatType || "-"}
                    </td>

                    <td>

                        <span
                            class="status ${statusClass}">

                            ${statusText}

                        </span>

                    </td>

                `;


                tableBody.appendChild(row);

            }
        );

    }
    catch (error) {

        console.error(
            "Error loading recent enquiries:",
            error
        );


        tableBody.innerHTML = `

            <tr>

                <td
                    colspan="4"
                    class="text-center text-danger">

                    Unable to load enquiries.

                </td>

            </tr>

        `;

    }

}



// =====================================================
// LOAD ALL DASHBOARD DATA
// =====================================================

loadTotalEnquiries();

loadTotalFollowUps();

loadTotalSiteVisits();

loadTotalFlatSales();

loadRecentEnquiries();