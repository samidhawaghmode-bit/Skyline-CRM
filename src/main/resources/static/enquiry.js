let editId = null;


// ==========================================
// PAGE LOAD
// ==========================================

document.addEventListener("DOMContentLoaded", function () {

    const params = new URLSearchParams(window.location.search);

    editId = params.get("id");

    if (editId) {

        // EDIT MODE
        loadEnquiry(editId);

    }

});


// ==========================================
// LOAD ENQUIRY FOR EDIT
// ==========================================

async function loadEnquiry(id) {

    try {

        const response = await fetch(
            "/skyline/dashboard/enquiry/" + id
        );

        if (!response.ok) {

            throw new Error("Failed to load enquiry");

        }

        const enquiry = await response.json();

        console.log("Enquiry for edit:", enquiry);


        // Fill existing values

        document.getElementById("enquiryDate").value =
            enquiry.enquiryDate ?? "";

        document.getElementById("enquiryNo").value =
            enquiry.enquiryNo ?? "";

        document.getElementById("project").value =
            enquiry.project ?? "";

        document.getElementById("flatType").value =
            enquiry.flatType ?? "";

        document.getElementById("customerName").value =
            enquiry.customerName ?? "";

        document.getElementById("mobile").value =
            enquiry.mobile ?? "";

        document.getElementById("budget").value =
            enquiry.budget ?? "";

        document.getElementById("source").value =
            enquiry.source ?? "";

        document.getElementById("location").value =
            enquiry.preferredLocation ?? "";

        document.getElementById("bedrooms").value =
            enquiry.bedrooms ?? "";

        document.getElementById("purpose").value =
            enquiry.purpose ?? "";

        document.getElementById("enquiryType").value =
            enquiry.enquiryType ?? "";


        // Change button text

        document.getElementById("saveBtn").innerHTML =
            '<i class="bi bi-pencil-square me-1"></i> Update Enquiry';

    }

    catch (error) {

        console.error(error);

        alert("Unable to load enquiry.");

    }

}