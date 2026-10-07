
async function loadUsers() {

    try {

        const response =
            await fetch("/skyline/users");


        if (!response.ok) {

            throw new Error(
                "Failed to load users"
            );

        }


        const users =
            await response.json();


        console.log("Users:", users);


        displayUsers(users);

    }

    catch (error) {

        console.error(error);


        document.getElementById("loading").innerHTML = `

            <div class="alert alert-danger">

                <i class="bi bi-exclamation-triangle me-2"></i>

                Unable to load users.

            </div>

        `;

    }

}



// =====================================================
// DISPLAY USERS IN TABLE
// =====================================================

function displayUsers(users) {

    const tableBody =
        document.getElementById(
            "userTableBody"
        );


    const loading =
        document.getElementById(
            "loading"
        );


    const noData =
        document.getElementById(
            "noData"
        );


    // Clear old data

    tableBody.innerHTML = "";


    // Hide loading

    loading.style.display = "none";


    // If no users

    if (users.length === 0) {

        noData.style.display = "block";

        return;

    }


    noData.style.display = "none";


    // Create table rows

    users.forEach(function(user) {

        const row =
            document.createElement("tr");


        let roleBadge = "";


        if (user.role === "ADMIN") {

            roleBadge = `
                <span class="badge badge-admin">
                    ADMIN
                </span>
            `;

        }

        else {

            roleBadge = `
                <span class="badge badge-employee">
                    ${user.role ?? ""}
                </span>
            `;

        }


        row.innerHTML = `

            <td>
                ${user.id ?? ""}
            </td>

            <td>

                <strong>
                    ${user.username ?? ""}
                </strong>

            </td>

            <td>

                ${roleBadge}

            </td>

        `;


        tableBody.appendChild(row);

    });

}



// =====================================================
// LOGOUT
// =====================================================

function logout() {

    localStorage.removeItem("userRole");

    localStorage.removeItem("username");

    window.location.href =
        "/index.html";

}



// =====================================================
// LOAD USERS WHEN PAGE OPENS
// =====================================================

document.addEventListener(
    "DOMContentLoaded",
    function () {

        loadUsers();

    }
);