// =====================================================
// SKYLINE CRM - LEAD
// =====================================================


// =====================================================
// GLOBAL VARIABLE
// =====================================================

let allLeads = [];


// =====================================================
// LOAD LEADS
// =====================================================

async function loadLeads() {

    try {

        const response = await fetch(
            "/skyline/dashboard/lead"
        );


        if (!response.ok) {

            throw new Error(
                "Failed to load leads"
            );

        }


        const leads = await response.json();


        console.log("Leads:", leads);


        allLeads = leads;


        displayLeads(leads);

    }
    catch (error) {

        console.error(error);


        document.getElementById("loading").innerHTML = `

            <div class="alert alert-danger">

                <i class="bi bi-exclamation-triangle me-2"></i>

                Unable to load leads.

            </div>

        `;

    }

}


// =====================================================
// DISPLAY LEADS
// =====================================================

function displayLeads(leads) {


    const tableBody =
        document.getElementById(
            "leadTableBody"
        );


    const loading =
        document.getElementById(
            "loading"
        );


    const noData =
        document.getElementById(
            "noData"
        );


    tableBody.innerHTML = "";


    loading.style.display = "none";


    // No leads

    if (leads.length === 0) {

        noData.style.display = "block";

        return;

    }


    noData.style.display = "none";


    // Create rows

    leads.forEach(function(lead) {


        const row =
            document.createElement("tr");


        const statusClass =
            getStatusClass(
                lead.leadStatus
            );


        row.innerHTML = `

            <td>

                ${lead.id ?? ""}

            </td>


            <td>

                <span class="lead-id">

                    ${lead.leadId ?? ""}

                </span>

            </td>


            <td>

                <strong class="customer-name">

                    ${lead.customerName ?? ""}

                </strong>

            </td>


            <td>

                ${lead.mobile ?? ""}

            </td>


            <td>

                <span class="badge-source">

                    ${lead.source ?? ""}

                </span>

            </td>


            <td>

                <span
                    class="badge-status ${statusClass}">

                    ${lead.leadStatus ?? ""}

                </span>

            </td>


            <td>

                ${lead.assignTo ?? ""}

            </td>


            <td>

                ${lead.createdDate ?? ""}

            </td>


            <td>


                <!-- VIEW -->

                <button
                    class="btn btn-sm btn-view me-1"
                    onclick="viewLead(${lead.id})"
                    title="View">

                    <i class="bi bi-eye"></i>

                </button>


                <!-- EDIT -->

                <button
                    class="btn btn-sm btn-edit me-1"
                    onclick="editLead(${lead.id})"
                    title="Edit">

                    <i class="bi bi-pencil"></i>

                </button>


                <!-- DELETE -->

                <button
                    class="btn btn-sm btn-delete"
                    onclick="deleteLead(${lead.id})"
                    title="Delete">

                    <i class="bi bi-trash"></i>

                </button>


            </td>

        `;


        tableBody.appendChild(row);


    });

}


// =====================================================
// STATUS CLASS
// =====================================================

function getStatusClass(status) {


    if (!status) {

        return "";

    }


    switch (
        status.toLowerCase()
        ) {


        case "new":

            return "status-new";


        case "contacted":

            return "status-contacted";


        case "in progress":

            return "status-progress";


        case "follow up":

            return "status-followup";


        case "converted":

            return "status-converted";


        default:

            return "";

    }

}


// =====================================================
// SEARCH
// =====================================================

function searchLead() {


    const search =
        document
            .getElementById("searchInput")
            .value
            .toLowerCase()
            .trim();


    const filtered =
        allLeads.filter(
            function(lead) {


                return (

                    String(
                        lead.id ?? ""
                    )
                        .toLowerCase()
                        .includes(search)


                    ||


                    (
                        lead.leadId ?? ""
                    )
                        .toLowerCase()
                        .includes(search)


                    ||


                    (
                        lead.customerName ?? ""
                    )
                        .toLowerCase()
                        .includes(search)


                    ||


                    (
                        lead.mobile ?? ""
                    )
                        .toLowerCase()
                        .includes(search)


                    ||


                    (
                        lead.source ?? ""
                    )
                        .toLowerCase()
                        .includes(search)


                    ||


                    (
                        lead.leadStatus ?? ""
                    )
                        .toLowerCase()
                        .includes(search)


                    ||


                    (
                        lead.assignTo ?? ""
                    )
                        .toLowerCase()
                        .includes(search)

                );

            }
        );


    displayLeads(filtered);

}


// =====================================================
// FILTER
// =====================================================

function filterLeads() {


    const source =
        document.getElementById(
            "leadSourceFilter"
        ).value;


    const status =
        document.getElementById(
            "leadStatusFilter"
        ).value;


    const assignTo =
        document.getElementById(
            "assignToFilter"
        ).value;


    const fromDate =
        document.getElementById(
            "fromDate"
        ).value;


    const toDate =
        document.getElementById(
            "toDate"
        ).value;


    const filtered =
        allLeads.filter(
            function(lead) {


                // SOURCE

                if (
                    source &&
                    lead.source !== source
                ) {

                    return false;

                }


                // STATUS

                if (
                    status &&
                    lead.leadStatus !== status
                ) {

                    return false;

                }


                // ASSIGN TO

                if (
                    assignTo &&
                    lead.assignTo !== assignTo
                ) {

                    return false;

                }


                // DATE

                if (
                    fromDate ||
                    toDate
                ) {


                    const leadDate =
                        convertDate(
                            lead.createdDate
                        );


                    if (
                        fromDate &&
                        leadDate < fromDate
                    ) {

                        return false;

                    }


                    if (
                        toDate &&
                        leadDate > toDate
                    ) {

                        return false;

                    }

                }


                return true;

            }
        );


    displayLeads(filtered);

}


// =====================================================
// DATE CONVERSION
// =====================================================

function convertDate(dateString) {


    if (!dateString) {

        return "";

    }


    /*
        Example:

        16 Sep 2026

        becomes:

        2026-09-16
    */


    const parts =
        dateString.split(" ");


    if (
        parts.length !== 3
    ) {

        return "";

    }


    const day =
        parts[0].padStart(
            2,
            "0"
        );


    const months = {

        Jan: "01",
        Feb: "02",
        Mar: "03",
        Apr: "04",
        May: "05",
        Jun: "06",
        Jul: "07",
        Aug: "08",
        Sep: "09",
        Oct: "10",
        Nov: "11",
        Dec: "12"

    };


    const month =
        months[parts[1]];


    const year =
        parts[2];


    if (!month) {

        return "";

    }


    return (
        year +
        "-" +
        month +
        "-" +
        day
    );

}


// =====================================================
// VIEW
// =====================================================

async function viewLead(id) {


    try {


        const response =
            await fetch(
                "/skyline/dashboard/lead/" +
                id
            );


        if (!response.ok) {

            throw new Error(
                "Lead not found"
            );

        }


        const lead =
            await response.json();


        document.getElementById(
            "viewLeadId"
        ).textContent =
            lead.leadId ?? "-";


        document.getElementById(
            "viewCustomerName"
        ).textContent =
            lead.customerName ?? "-";


        document.getElementById(
            "viewMobile"
        ).textContent =
            lead.mobile ?? "-";


        document.getElementById(
            "viewSource"
        ).textContent =
            lead.source ?? "-";


        document.getElementById(
            "viewLeadStatus"
        ).textContent =
            lead.leadStatus ?? "-";


        document.getElementById(
            "viewAssignTo"
        ).textContent =
            lead.assignTo ?? "-";


        document.getElementById(
            "viewCreatedDate"
        ).textContent =
            lead.createdDate ?? "-";


        const modal =
            new bootstrap.Modal(
                document.getElementById(
                    "viewLeadModal"
                )
            );


        modal.show();


    }
    catch (error) {

        console.error(error);


        alert(
            "Unable to load lead details."
        );

    }

}


// =====================================================
// EDIT
// =====================================================

function editLead(id) {


    window.location.href =
        "addlead.html?id=" +
        id;

}


// =====================================================
// DELETE
// =====================================================

async function deleteLead(id) {


    const confirmDelete =
        confirm(
            "Are you sure you want to delete this lead?"
        );


    if (!confirmDelete) {

        return;

    }


    try {


        const response =
            await fetch(
                "/skyline/dashboard/lead/" +
                id,
                {
                    method: "DELETE"
                }
            );


        if (response.ok) {


            alert(
                "Lead deleted successfully!"
            );


            loadLeads();


        }
        else {


            alert(
                "Failed to delete lead."
            );

        }

    }
    catch (error) {


        console.error(error);


        alert(
            "Server connection failed."
        );

    }

}


// =====================================================
// LOGOUT
// =====================================================

function logout() {


    const confirmLogout =
        confirm(
            "Are you sure you want to logout?"
        );


    if (confirmLogout) {

        window.location.href =
            "login.html";

    }

}


// =====================================================
// PAGE LOAD
// =====================================================

loadLeads();