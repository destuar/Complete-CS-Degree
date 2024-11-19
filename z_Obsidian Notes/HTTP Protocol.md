**HTTP Protocol is a set of rules used for transmitting information between clients and servers on the [[Internet]].**

HTTP (Hypertext Transfer Protocol) is an [[Application Layer]] protocol used for transmitting hypertext via the internet. It is the foundation of data communication on the World Wide Web and enables the transfer of web pages, images, videos, and other types of content between clients (usually web browsers) and servers.

### Key Features of HTTP:

1. **Request-Response Model:** HTTP follows a request-response model where the client sends an HTTP request to a server, which then responds with the requested resources. The client typically initiates the communication.
    
2. **Stateless Protocol:** Each HTTP request is independent, meaning that the server does not retain information about previous requests. This stateless nature makes the protocol simple but requires additional mechanisms (like cookies or sessions) for maintaining state across multiple requests.
    
3. **Methods:** HTTP defines several methods (also known as verbs) that specify the desired action to be performed on the identified resource. The most commonly used methods include:
    
    - **GET:** Retrieve data from a server (e.g., web pages).
    - **POST:** Send data to a server to create or update a resource (e.g., form submissions).
    - **PUT:** Update an existing resource or create a new one at a specified URI.
    - **DELETE:** Remove a resource from the server.
    - **HEAD:** Retrieve only the headers of a resource without the body.
4. **Status Codes:** HTTP responses include status codes that indicate the result of the request. Common status codes include:
    
    - **200 OK:** The request was successful, and the server returned the requested data.
    - **404 Not Found:** The requested resource could not be found on the server.
    - **500 Internal Server Error:** The server encountered an unexpected condition that prevented it from fulfilling the request.
5. **Headers:** HTTP requests and responses can include headers that provide additional information about the request or response, such as content type, content length, caching directives, and user-agent information.
    
6. **HTTPS (HTTP Secure):** HTTPS is the secure version of HTTP, which uses Transport Layer Security (TLS) to encrypt the data transmitted between the client and server, ensuring confidentiality and integrity. It is widely used for secure communication, especially for online transactions.
### Use Cases:

HTTP is primarily used for:

- **Web Browsing:** Loading web pages and their resources.
- **APIs:** Enabling communication between web services and applications.
- **File Transfers:** Transferring files over the web.

HTTP is essential for the functioning of the internet, allowing users to access information and services seamlessly across different devices and platforms.