package com.wangwenjun.guava.Collection;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TableExample {
    //ArrayTable
    //TreeBaseTable
    //ImmutableTable
    //Bag
    @Test
    public void test(){
        Table<String,String,String> table = HashBasedTable.create();
        table.put("language","java","1.8");
        table.put("language","scala","1.8");
        table.put("database","oracle","12c");
        System.out.println(table);
        Map<String,String> language = table.row("language");
        assertThat(language.containsKey("java"),equalTo(true));
        Map<String,String> map = table.column("Java");
        System.out.println(map);
        Set<Table.Cell<String,String,String>> cells = table.cellSet();
        System.out.println(cells);
    }



}
