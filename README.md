<!--
Auto-generated on 2025-08-20. You can edit this file directly.
-->
<div align="center">
  <h1>InvoiceApplication — Spring Boot PDF Invoice Generator</h1>
  <p><em>Create and download a vehicle sale invoice as a PDF via a simple REST API.</em></p>

  <p>
    <img src="https://img.shields.io/badge/Java-17+-red" alt="Java 17+">
    <img src="https://img.shields.io/badge/Spring%20Boot-3.3.x-brightgreen" alt="Spring Boot 3.3">
    <img src="https://img.shields.io/badge/Build-Maven-blue" alt="Maven">
    <img src="https://img.shields.io/badge/PDF-openpdf-blueviolet" alt="OpenPDF">
  </p>
</div>

<hr/>

<section>
  <h2>📌 Overview</h2>
  <p>
    This is a minimal Spring Boot application that generates a <strong>PDF invoice</strong> for a vehicle purchase.
    You call a single endpoint with the dealer, vehicle and customer details, and the app returns a PDF as the response.
  </p>
</section>

<section>
  <h2>🚀 Quick Start</h2>
  <ol>
    <li>Install <strong>Java 17+</strong> and <strong>Maven 3.9+</strong>.</li>
    <li>Clone this repository and enter the project folder:</li>
  </ol>
  <pre><code>git clone &lt;your-repo-url&gt;
cd InvoiceApplication/InvoiceApplication
  </code></pre>

  <ol start="3">
    <li>Build and run:</li>
  </ol>
  <pre><code>mvn spring-boot:run
# or
mvn clean package
java -jar target/invoice-application-0.0.1-SNAPSHOT.jar
  </code></pre>

  <p>By default, the app listens on <code>http://localhost:8080</code>.</p>
</section>

<section>
  <h2>🧭 REST API</h2>
  <h3>GET <code>/invoice</code></h3>
  <p>Generates a PDF invoice and returns it as <code>application/pdf</code>.</p>

  <table>
    <thead>
      <tr><th>Query Parameter</th><th>Type</th><th>Required</th><th>Description</th></tr>
    </thead>
    <tbody>
      <tr><td><code>dealerId</code></td><td>string</td><td>Yes</td><td>Dealer identifier (used to populate sample dealer data)</td></tr>
      <tr><td><code>vehicleId</code></td><td>string</td><td>Yes</td><td>Vehicle identifier (used to populate sample vehicle data)</td></tr>
      <tr><td><code>customerName</code></td><td>string</td><td>Yes</td><td>Customer's full name</td></tr>
    </tbody>
  </table>

  <details>
    <summary><strong>Example Request (Browser)</strong></summary>
    <pre><code>http://localhost:8080/invoice?dealerId=E1&amp;vehicleId=V1&amp;customerName=John%20Doe</code></pre>
  </details>

  <details>
    <summary><strong>Example: cURL</strong></summary>
    <pre><code>curl -X GET "http://localhost:8080/invoice?dealerId=E1&amp;vehicleId=V1&amp;customerName=John%20Doe" \
  -H "Accept: application/pdf" \
  -o invoice.pdf</code></pre>
  </details>

  <details>
    <summary><strong>Example: Postman</strong></summary>
    <ol>
      <li>Create a new <strong>GET</strong> request.</li>
      <li>URL: <code>http://localhost:8080/invoice?dealerId=E1&amp;vehicleId=V1&amp;customerName=John%20Doe</code></li>
      <li>Send the request and use <em>Save Response</em> to download the PDF.</li>
    </ol>
  </details>

  <p><em>Note:</em> In this sample, the dealer and vehicle details are populated in the controller from the provided IDs (no database). The service calculates 10% tax and the total, then <code>PdfUtil</code> renders a simple PDF.</p>
</section>

<section>
  <h2>🧱 Project Structure</h2>
  <pre><code>InvoiceApplication/
└─ InvoiceApplication/
   ├─ pom.xml
   └─ src/
      └─ main/
         ├─ java/
         │  └─ org/application/
         │     ├─ InvoiceApplication.java        # Spring Boot bootstrap
         │     ├─ controller/InvoiceController.java   # /invoice endpoint
         │     ├─ service/InvoiceService.java    # Invoice creation logic (tax, totals)
         │     ├─ utils/PdfUtil.java             # PDF rendering (OpenPDF)
         │     └─ model/
         │        ├─ Dealer.java
         │        ├─ Vehicle.java
         │        └─ Invoice.java
         └─ resources/ (none required)
  </code></pre>
</section>

<section>
  <h2>🛠️ Tech Stack</h2>
  <ul>
    <li><strong>Java</strong> 17+</li>
    <li><strong>Spring Boot</strong> 3.3.x (<code>spring-boot-starter-web</code>)</li>
    <li><strong>OpenPDF</strong> for PDF generation</li>
    <li><strong>Maven</strong> for build</li>
  </ul>
</section>

<section>
  <h2>🧪 How It Works</h2>
  <ol>
    <li><code>InvoiceController</code> accepts the request with <code>dealerId</code>, <code>vehicleId</code>, and <code>customerName</code>.</li>
    <li>It creates <code>Dealer</code> and <code>Vehicle</code> objects (sample data from IDs) and calls <code>InvoiceService</code>.</li>
    <li><code>InvoiceService</code> computes a 10% tax and the total and returns an <code>Invoice</code>.</li>
    <li><code>PdfUtil</code> builds the PDF and the controller streams the bytes back as <code>application/pdf</code> with a filename like <code>INV-XXXXXXXX.pdf</code>.</li>
  </ol>
</section>

<section>
  <h2>🧰 Build &amp; Packaging</h2>
  <pre><code># Run locally (dev)
mvn spring-boot:run

# Create a fat JAR (prod)
mvn clean package

# Run the JAR
java -jar target/invoice-application-0.0.1-SNAPSHOT.jar
  </code></pre>
</section>

<section>
  <h2>🔐 Configuration</h2>
  <p>No external configuration or database is required for this sample. Default port is <code>8080</code>.</p>
</section>

<section>
  <h2>📄 License</h2>
  <p>MIT — feel free to use and adapt.</p>
</section>
