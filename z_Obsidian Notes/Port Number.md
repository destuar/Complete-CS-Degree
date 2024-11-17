**This is a naming system used to identify programs running on a single computer.**

Port numbers are numerical identifiers in networking used to differentiate between multiple services or applications running on a single device. They enable communication between devices over the [[Internet]] or within a local network by allowing multiple services to operate concurrently without interference. Each port number corresponds to a specific process or service, making it easier for networked devices to identify where to send or receive data.

Port numbers are categorized into three ranges:

1. **Well-Known Ports (0-1023):** These ports are assigned by the Internet Assigned Numbers Authority (IANA) and are reserved for specific protocols and services. Common examples include:
    
    - **HTTP:** Port 80 (used for web traffic)
    - **HTTPS:** Port 443 (used for secure web traffic)
    - **FTP:** Port 21 (used for file transfer)
    - **SSH:** Port 22 (used for secure shell access)
2. **Registered Ports (1024-49151):** These ports are not as strictly regulated as well-known ports but are registered with IANA for specific services. Organizations can request the registration of a port number for their applications, but they are not guaranteed to be unique. Examples include:
    
    - **MySQL:** Port 3306
    - **PostgreSQL:** Port 5432
3. **Dynamic or Private Ports (49152-65535):** These ports are used for private or temporary connections. They are often assigned dynamically by the operating system when a program requests a network connection. Applications may use these ports for ephemeral communication during a session.

When data packets are sent over the network, they include both the source and destination IP addresses as well as the corresponding port numbers. This combination ensures that the data reaches the correct application or service on the intended device, enabling efficient communication and resource sharing.

Additional Notes:
**Socket:** A connection between multiple computers, combining [[IP Address]]es and [[Port Number]]s.