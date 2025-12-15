package com.ithink.application.port.in;
/**
 * Interfaz de Loggin
 * JB
 * */
public interface LoggerPort {
    /**
     * Registra un mensaje informativo (nivel INFO).
     *
     * @param message Mensaje a registrar, puede contener placeholders como {}.
     * @param args    Argumentos que serán insertados en el mensaje.
     */
    void info(String message, Object... args);
    /**
     * Registra una advertencia (nivel WARN).
     *
     * @param message Mensaje a registrar, puede contener placeholders como {}.
     * @param args    Argumentos que serán insertados en el mensaje.
     */
    void warn(String message, Object... args);
    /**
     * Registra un error (nivel ERROR) junto con la excepción lanzada.
     *
     * @param message   Mensaje descriptivo del error.
     * @param throwable Excepción asociada al error.
     * @param args      Argumentos adicionales para el mensaje.
     */
    void error(String message, Throwable throwable, Object... args);
    /**
     * Registra un error (nivel ERROR) sin excepción asociada.
     *
     * @param message Mensaje de error.
     * @param args    Argumentos adicionales para el mensaje.
     */
    void error(String message, Object... args);
}
