# Networking Lab Repository

## Table of Contents
1. [Overview](#overview)
2. [Project Structure](#project-structure)
3. [Cisco Networking Files](#cisco-networking-files)
4. [Java Applications](#java-applications)
5. [Getting Started](#getting-started)
6. [File Descriptions](#file-descriptions)

---

## Overview

This repository contains networking lab exercises and Java-based networking applications. It includes Cisco Packet Tracer network simulations and Java implementations of client-server communication patterns, including email functionality.

---

## Project Structure

```
Networking-Lab/
├── README.md                          # Project documentation
├── Cisco/                             # Cisco Packet Tracer files
│   ├── DynamicRouting.pkt            # Dynamic routing simulation
│   ├── DynamicRoutingConfig.txt      # Dynamic routing configuration
│   ├── simpleIntro.pkt               # Introduction to networking
│   ├── static_routing_with_4_router.pkt  # Static routing with 4 routers
│   ├── staticRouting.pkt             # Static routing simulation
│   ├── Vlan.pkt                      # VLAN configuration
│   ├── VLAN.pkt                      # Alternative VLAN setup
│   └── vLANConfig.txt                # VLAN configuration details
│
└── JAVA/                             # Java networking applications
    ├── Client&Server/                # Client-server implementations
    │   ├── Client.java               # Main client implementation
    │   ├── Server.java               # Main server implementation
    │   ├── Date and Time/            # Date and time service
    │   │   ├── client.java           # Date/time client
    │   │   └── server.java           # Date/time server
    │   └── Exam/                     # Exam-related implementations
    │       ├── Client.java           # Exam client
    │       └── Server.java           # Exam server
    │
    └── Email/                        # Email service implementation
        ├── CCEmail.java              # CC Email functionality
        └── Email.java                # Basic email implementation
```

---

## Cisco Networking Files

### Routing Simulations

#### Step 1: Static Routing
- **staticRouting.pkt** - Basic static routing configuration
- **static_routing_with_4_router.pkt** - Advanced static routing with 4 routers
- These files demonstrate how to configure routers to forward packets using predefined routes

#### Step 2: Dynamic Routing
- **DynamicRouting.pkt** - Dynamic routing protocol simulation
- **DynamicRoutingConfig.txt** - Configuration details for dynamic routing setup
- Shows automatic route discovery and adjustment

#### Step 3: VLAN Configuration
- **VLAN.pkt** - Virtual LAN network setup
- **Vlan.pkt** - Alternative VLAN configuration
- **vLANConfig.txt** - VLAN configuration documentation
- Demonstrates network segmentation using VLAN technology

#### Step 4: Introductory Concepts
- **simpleIntro.pkt** - Basic networking concepts and setup

---

## Java Applications

### Step 1: Basic Client-Server Communication

#### Main Client-Server Pair
- **Client.java** - Client application that connects to the server
- **Server.java** - Server application that listens for client connections
- Basic implementation of socket-based communication

### Step 2: Date and Time Service
- **Date and Time/client.java** - Client requesting date/time from server
- **Date and Time/server.java** - Server providing current date/time
- Demonstrates real-time data exchange between client and server

### Step 3: Exam Applications
- **Exam/Client.java** - Exam client application
- **Exam/Server.java** - Exam server application
- Advanced client-server implementation for exam scenarios

### Step 4: Email Service
- **Email.java** - Basic email sending functionality
- **CCEmail.java** - Email with CC (Carbon Copy) support
- Implements email protocol and features

---

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Cisco Packet Tracer (for .pkt files)
- Text editor or IDE (e.g., VS Code, IntelliJ IDEA)

### Steps to Run Java Applications

#### Step 1: Navigate to Project Directory
```bash
cd /home/noman/MyFiles/Academic/Lab/Networking-Lab
```

#### Step 2: Compile Java Files
```bash
javac JAVA/Client&Server/Server.java
javac JAVA/Client&Server/Client.java
```

#### Step 3: Run the Server
```bash
java -cp JAVA/Client&Server/ Server
```

#### Step 4: Run the Client
```bash
java -cp JAVA/Client&Server/ Client
```

### Steps to Use Cisco Packet Tracer Files

#### Step 1: Launch Cisco Packet Tracer
Open Cisco Packet Tracer application

#### Step 2: Open a Network File
File → Open → Select .pkt file from Cisco/ directory

#### Step 3: Simulate the Network
Click the "Simulation" tab to run the network simulation

#### Step 4: Test Connectivity
Use Packet Tracer's built-in tools to test connectivity between devices

---

## File Descriptions

### Cisco Network Files

| File Name | Type | Purpose |
|-----------|------|---------|
| staticRouting.pkt | Packet Tracer | Basic static routing setup |
| static_routing_with_4_router.pkt | Packet Tracer | Advanced 4-router topology |
| DynamicRouting.pkt | Packet Tracer | Dynamic routing protocols |
| DynamicRoutingConfig.txt | Configuration | Dynamic routing setup details |
| VLAN.pkt | Packet Tracer | Virtual LAN configuration |
| Vlan.pkt | Packet Tracer | Alternative VLAN setup |
| vLANConfig.txt | Configuration | VLAN configuration info |
| simpleIntro.pkt | Packet Tracer | Introductory networking concepts |

### Java Source Files

| File Name | Location | Purpose |
|-----------|----------|---------|
| Server.java | Client&Server/ | Main server implementation |
| Client.java | Client&Server/ | Main client implementation |
| server.java | Date and Time/ | Date/time server |
| client.java | Date and Time/ | Date/time client |
| Server.java | Exam/ | Exam mode server |
| Client.java | Exam/ | Exam mode client |
| Email.java | Email/ | Basic email service |
| CCEmail.java | Email/ | Email with CC support |

---

## Additional Resources

### For Cisco Networking
- [Cisco Packet Tracer Documentation](https://www.netacad.com/)
- Refer to configuration text files for detailed setup instructions

### For Java Networking
- [Java Socket Programming Guide](https://docs.oracle.com/javase/tutorial/networking/sockets/)
- Review individual Java source files for inline code documentation

---

## Notes

- Ensure proper network connectivity configurations before running simulations
- Java applications use standard socket communication protocols
- Configuration files provide step-by-step setup instructions for network topologies
- Test connectivity after configuring each network simulation

---

**Last Updated:** April 2026
