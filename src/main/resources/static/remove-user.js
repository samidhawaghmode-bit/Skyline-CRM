// =====================================================
// REMOVE USER
// =====================================================

document
    .getElementById("removeUserForm")
    .addEventListener("submit", async function(event) {

        event.preventDefault();


        const userId =
            document.getElementById("userId").value;


        const message =
            document.getElementById("message");


        // Confirmation

        const confirmDelete =
            confirm(
                "Are you sure you want to remove this user?"
            );


        if (!confirmDelete) {
            return;
        }


        try {

            const response =
                await fetch(
                    "/skyline/users/" + userId,
                    {
                        method: "DELETE"
                    }
                );


            if (!response.ok) {

                throw new Error(
                    "Failed to remove user"
                );

            }


            message.innerHTML = `

                <div class="alert alert-success">

                    <i class="bi bi-check-circle me-2"></i>

                    User removed successfully.

                </div>

            `;


            document.getElementById("userId").value = "";


        }

        catch (error) {

            console.error(error);


            message.innerHTML = `

                <div class="alert alert-danger">

                    <i class="bi bi-exclamation-triangle me-2"></i>

                    Unable to remove user.

                </div>

            `;

        }

    });



// =====================================================
// LOGOUT
// =====================================================

function logout() {

    localStorage.removeItem("userRole");

    localStorage.removeItem("username");

    window.location.href =
        "/index.html";

}