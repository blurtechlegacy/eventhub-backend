package tech.blur.eventhub.api;

import lombok.Data;

/**
 * Базовая модель ответа сервера
 */
@Data
public class BaseResponse<T> {

  public static final String SUCCESS_STATUS = "OK";


  private String status = SUCCESS_STATUS;
  private T data;
  private String message;

}
