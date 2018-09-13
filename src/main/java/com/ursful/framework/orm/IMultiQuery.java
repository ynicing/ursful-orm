/*
 * Copyright 2017 @ursful.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ursful.framework.orm;


import com.ursful.framework.orm.support.*;

import java.util.List;

public interface IMultiQuery extends IQuery{

    //IMultiQuery createDistinctQuery(Class<?> clazz, Column... columns) throws ORMException;
    IMultiQuery createQuery(Class<?> clazz, Column... columns);//select a.id, a.name from
    IMultiQuery createQuery(Class<?> clazz, Columns... columns);//select a.id, a.name from

    IMultiQuery createQuery(Column ... columns);

    //IMultiQuery createCount() throws ORMException;;//select count(*) from.
    //IMultiQuery createCount(Column column) throws ORMException;//select count(a.id) from...
    //IMultiQuery createDistinctString(Column column) throws ORMException;
    //IMultiQuery createPage(Page page) throws ORMException;// page...
    //QueryInfo getQueryInfo();
    AliasTable table(IQuery query);
    AliasTable table(Class<?> clazz);

    AliasTable join(IQuery query);
    AliasTable join(Class<?> clazz);

    IMultiQuery whereEqual(Column left, Object value);
    IMultiQuery whereNotEqual(Column left, Object value);

    IMultiQuery whereLike(Column left, String value);
    IMultiQuery whereNotLike(Column left, String value);
    IMultiQuery whereStartWith(Column left, String value);
    IMultiQuery whereEndWith(Column left, String value);

    IMultiQuery whereLess(Column left, Object value);
    IMultiQuery whereLessEqual(Column left, Object value);
    IMultiQuery whereMore(Column left, Object value);
    IMultiQuery whereMoreEqual(Column left, Object value);

    IMultiQuery where(Column left, ExpressionType type);
    IMultiQuery whereIsNull(Column left);
    IMultiQuery whereIsNotNull(Column left);
    IMultiQuery where(Column left, Object value, ExpressionType type);
    IMultiQuery where(Column left, Column value);
    IMultiQuery where(Column left, Column value, ExpressionType type);
    IMultiQuery where(Condition condition);
    IMultiQuery where(Expression ... expressions);
    IMultiQuery group(Column ...column);
    IMultiQuery group(Columns ...columns);
    IMultiQuery having(Column left, Object value, ExpressionType type);
    IMultiQuery having(Column left, Column value);
    IMultiQuery having(Condition condition);
    IMultiQuery orderDesc(Column column);
    IMultiQuery orderAsc(Column column);
    IMultiQuery orders(List<Order> orders);

    IMultiQuery join(Join join);
    IMultiQuery distinct();

    boolean containsAlias(String alias);



}
