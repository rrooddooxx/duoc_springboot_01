package com.matrix.duoc_springboot_01.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Language {
  private Long langId;
  private String langName;
}
