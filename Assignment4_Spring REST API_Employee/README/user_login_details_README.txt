Employee Controller:
Role: ADMIN
Username: Nandita
password: nandita
Priviledges: All priviledges in employee controller api(add, delete, update, sort, search, findbyID, findall)

Role: USER 
Username: Pooja
password: pooja
Priviledges: No 'Add' new Employee priviledges (delete, update, sort, search, findbyID, findAll - found in employee controller)
---------------------------
USer COntroller

Priviledges: All priviledges in USer Controller
User details Service(UDS) User
Role: UDS_ADMIN
Username: UDS
password: uds

NO need to insert any users or roles, using data.sql to load the data dynamically.
I have also done the same in program, currently commented, pls uncomment that and some other user related stuff to make it work ..worked with user, role added inMemory to work with UDS

API is secure, all request are authenticated, the roles authorised. Unnecessary endpoints not exposed to the user.

User , Roles added only by UDS_ADMIN.
