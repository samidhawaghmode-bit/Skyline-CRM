document
    .getElementById("updateUserForm")
    .addEventListener("submit", async function(event) {

        event.preventDefault();

        const userId =
            document.getElementById("userId").value;

        const username =
            document.getElementById("username").value;

        const role =
            document.getElementById("role").value;

        const message =
            document.getElementById("message");


        try {

            const response =
                await fetch(
                    "/skyline/users/" + userId,
                    {
                        method: "PUT",

                        headers: {
                            "Content-Type": "application/json"
                        },

                        body: JSON.stringify({

                            username: username,
                            role: role

                        })
                    }
                );


            if (!response.ok) {

                throw new Error(
                    "Failed to update user"
                );

            }


            message.innerHTML = `
                <div class="alert alert-success">
                    <i class="bi bi-check-circle me-2"></i>
                    User updated successfully.
                </div>
            `;


        } catch (error) {

            console.error(error);

            message.innerHTML = `
                <div class="alert alert-danger">
                    <i class="bi bi-exclamation-triangle me-2"></i>
                    Unable to update user.
                </div>
            `;

        }

    });


function logout() {

    localStorage.removeItem("userRole");

    localStorage.removeItem("username");

    window.location.href = "/index.html";
}