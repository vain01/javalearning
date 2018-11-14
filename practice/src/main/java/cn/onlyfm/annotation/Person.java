package cn.onlyfm.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author haoliang on 2018/5/14.
 */

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Person{
	private String name;
	private Integer height;
	private Integer weight;
}
