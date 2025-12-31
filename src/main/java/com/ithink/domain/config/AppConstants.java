package com.ithink.domain.config;
/**
 * Constantes de la aplicacion
 * JB
 * */
public class AppConstants {
    public static final String CANAL = "CRD";
    public static final String M_INI = "INICIA -->";
    public static final String HANDLER_INI = "\n PETICION INICIA -->";
    public static final String M_FIN = "FIN -->";
    public static final String HANDLER_FIN = "\n PETICION FIN -->";
    public static final String KEY_TOKEN_ZIMA = "";

    //Codigos de respuesta
    public static final String COD_ERROR = "ERROR";
    //Error en el envio de datos del cliente
    public static final String COD_ERROR_01 = "ERROR01";
    public static final String COD_OK = "OK";
    //Tiempo de espera por la conexion con el servicio: 10 segundos
    public static final Integer TIME_OUT_CONNECTION = 10000;
    //Tiempo de espera por la respuesta: 40 segundos
    public static final Integer TIME_OUT_READ = 40000;

    //Id de la Transaccion para Biometria
    public static  final Integer ID_TRANSACCION_BIOMETRIA = 1;
    
    public static final String SUPABASE_API_KEY = "apikey";
    public static final String SUPABASE_AUTHORIZATION = "Authorization";
}
