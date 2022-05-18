package rest_api_demo.org;

import lombok.Getter;

/**
 * Nustatymai (http_port,database, ir t.t.)
 */
@Getter
public enum Settings {
    HTTP_PORT("8080"),
    DATABASE("src/main/resources/Database/Database.obj"),
    HTML_HEADER("src/main/resources/HTMLTemplates/header.html"),
    HTML_FOOTER("src/main/resources/HTMLTemplates/footer.html"),
    HTML_INDEX("src/main/resources/index.html"),
    HTML_MENU("src/main/resources/menuurl.html"),
    HTML_TABLE("src/main/resources/JSONtable.html"),
    JAVA_SCRIPT("src/main/resources/js/script.js"),
    IMAGE("src/main/resources/image/image.jpg");

    String value;

    Settings(String value) {
        this.value = value;
    }
}
