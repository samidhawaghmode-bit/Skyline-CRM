// ============================================
// LOAD DAY BOOK
// ============================================

async function loadDayBooks() {

    const tableBody =
        document.getElementById("daybookTableBody");

    try {

        const response =
            await fetch("/skyline/dashboard/daybook");

        if (!response.ok) {

            throw new Error("Failed to load day book");

        }

        const dayBooks =
            await response.json();


        tableBody.innerHTML = "";


        if (dayBooks.length === 0) {

            tableBody.innerHTML = `
                <tr>
                    <td colspan="9"
                        class="text-center text-muted">

                        No Day Book entries found.

                    </td>
                </tr>
            `;

            updateSummary([]);

            return;
        }


        // Newest first

        dayBooks.sort(function(a, b) {

            return b.id - a.id;

        });


        dayBooks.forEach(function(dayBook) {

            const typeClass =
                dayBook.transactionType === "Receipt"
                    ? "type-receipt"
                    : "type-payment";


            const row = document.createElement("tr");


            row.innerHTML = `

                <td>
                    ${dayBook.id}
                </td>

                <td>
                    ${dayBook.transactionDate || ""}
                </td>

                <td>

                    <span class="${typeClass}">
                        ${dayBook.transactionType || ""}
                    </span>

                </td>

                <td>
                    ${dayBook.particulars || ""}
                </td>

                <td>
                    ${dayBook.referenceName || "-"}
                </td>

                <td>
                    ₹${dayBook.amount || "0"}
                </td>

                <td>
                    ${dayBook.paymentMode || ""}
                </td>

                <td>
                    ${dayBook.remarks || "-"}
                </td>

                <td>

                    <button
                        class="btn btn-sm btn-edit me-1"
                        onclick="editDayBook(${dayBook.id})">

                        <i class="bi bi-pencil"></i>

                    </button>


                    <button
                        class="btn btn-sm btn-delete"
                        onclick="deleteDayBook(${dayBook.id})">

                        <i class="bi bi-trash"></i>

                    </button>

                </td>

            `;


            tableBody.appendChild(row);

        });


        updateSummary(dayBooks);


    } catch (error) {

        console.error(error);

        tableBody.innerHTML = `

            <tr>

                <td
                    colspan="9"
                    class="text-center text-danger">

                    Failed to load Day Book entries.

                </td>

            </tr>

        `;

    }

}



// ============================================
// SUMMARY
// ============================================

function updateSummary(dayBooks) {

    let totalReceipts = 0;

    let totalPayments = 0;


    dayBooks.forEach(function(dayBook) {

        const amount =
            parseFloat(dayBook.amount) || 0;


        if (dayBook.transactionType === "Receipt") {

            totalReceipts += amount;

        }


        if (dayBook.transactionType === "Payment") {

            totalPayments += amount;

        }

    });


    const balance =
        totalReceipts - totalPayments;


    document.getElementById("totalReceipts").innerText =
        "₹" + totalReceipts.toFixed(2);


    document.getElementById("totalPayments").innerText =
        "₹" + totalPayments.toFixed(2);


    document.getElementById("balance").innerText =
        "₹" + balance.toFixed(2);

}



// ============================================
// ADD
// ============================================

function addDayBook() {

    window.location.href =
        "add-daybook.html";

}



// ============================================
// EDIT
// ============================================

function editDayBook(id) {

    window.location.href =
        "update-daybook.html?id=" + id;

}



// ============================================
// DELETE
// ============================================

async function deleteDayBook(id) {

    const confirmDelete =
        confirm(
            "Are you sure you want to delete this Day Book entry?"
        );


    if (!confirmDelete) {

        return;

    }


    try {

        const response =
            await fetch(
                "/skyline/dashboard/daybook/" + id,
                {
                    method: "DELETE"
                }
            );


        if (!response.ok) {

            throw new Error("Delete failed");

        }


        alert(
            "Day Book entry deleted successfully!"
        );


        loadDayBooks();


    } catch (error) {

        console.error(error);

        alert(
            "Failed to delete Day Book entry."
        );

    }

}



// ============================================
// LOGOUT
// ============================================

function logout() {

    const confirmLogout =
        confirm(
            "Are you sure you want to logout?"
        );


    if (confirmLogout) {

        window.location.href =
            "/login.html";

    }

}



// ============================================
// LOAD WHEN PAGE OPENS
// ============================================

document.addEventListener(
    "DOMContentLoaded",
    loadDayBooks
);