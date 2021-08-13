package com.ddxx.study.algorithms.java8;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamUtil {
    private StreamUtil() {}
    public static <K, V, E> Map<K, V> getMap(Collection<E> collection, Function<E, K> ekFunction, Function<E, V> evFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Maps.newHashMap();
        }
        return collection.stream()
                .collect(Collectors.toMap(ekFunction, evFunction, (a, b) -> a));
    }

    public static <K, E> Map<K, E> getMap(Collection<E> collection, Function<E, K> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Maps.newHashMap();
        }

        return getMap(collection, ekFunction, e -> e);
    }

    public static <K, V> Map<K, V> getMap(Collection<V> collection, Function<V, K> ekFunction, BinaryOperator<V> mergeFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Maps.newHashMap();
        }
        return collection.stream()
                .collect(Collectors.toMap(ekFunction, e -> e, mergeFunction));
    }

    public static <V, E> Set<V> getSet(Collection<E> collection, Function<E, V> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Sets.newHashSet();
        }
        return collection.stream().map(ekFunction).collect(Collectors.toSet());
    }

    public static <K, E> List<K> convertList(Collection<E> collection, Function<E, K> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }
        return collection.stream().map(ekFunction).collect(Collectors.toList());
    }

    public static <K, E> Set<K> convertSet(Collection<E> collection, Function<E, K> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Sets.newHashSet();
        }

        return collection.stream()
                .filter(Objects::nonNull)
                .map(ekFunction)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public static <K, E> List<K> convert2List(Collection<E> collection, Function<E, K> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }

        return collection.stream()
                .filter(Objects::nonNull)
                .map(ekFunction)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static <K, E> Set<K> convert2Set(Collection<E> collection, Function<E, K> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Sets.newHashSet();
        }
        return collection.stream().map(ekFunction).collect(Collectors.toSet());
    }

    public static <K, E> Set<K> convert2SetAndFilterNull(Collection<E> collection, Function<E, K> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Sets.newHashSet();
        }
        return collection.stream()
                .map(ekFunction)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public static <K, E> Set<K> convert2SetAndFilter(Collection<E> collection, Function<E, K> ekFunction, Predicate<K> ePredicate) {
        if (CollectionUtils.isEmpty(collection)) {
            return Sets.newHashSet();
        }
        return collection.stream()
                .map(ekFunction)
                .filter(ePredicate)
                .collect(Collectors.toSet());
    }

    public static <K, E> Map<K, List<E>> getGroupMap(Collection<E> collection, Function<E, K> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Maps.newHashMap();
        }
        return collection.stream()
                .collect(Collectors.groupingBy(ekFunction));
    }

    public static <K, V, E> Map<K, List<V>> getGroupMap(Collection<E> collection, Function<E, K> ekFunction, Function<E, V> evFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Maps.newHashMap();
        }
        return collection.stream()
                .collect(Collectors.groupingBy(ekFunction, Collectors.mapping(evFunction, Collectors.toList())));
    }

    public static <E> List<E> filterList(Collection<E> collection, Predicate<E> ePredicate) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }
        return collection.stream()
                .filter(ePredicate)
                .collect(Collectors.toList());
    }

    public static <E> List<E> filterAndDistinctList(Collection<E> collection, Predicate<E> ePredicate) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }
        return collection.stream()
                .filter(ePredicate)
                .distinct()
                .collect(Collectors.toList());
    }


    public static <E> List<E> filterListWithNegate(Collection<E> collection, Predicate<E> ePredicate) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }
        return filterList(collection, ePredicate.negate());
    }

    public static <E> List<E> filterArray(E[] array, Predicate<E> ePredicate) {
        if (array == null || array.length == 0) {
            return Lists.newArrayList();
        }
        return Arrays.stream(array)
                .filter(ePredicate).collect(Collectors.toList());
    }

    public static <E, V> List<V> convertAndFilterList(Collection<E> collection, Function<E, V> ekFunction, Predicate<V> ePredicate) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }
        return collection.stream()
                .map(ekFunction)
                .filter(ePredicate)
                .collect(Collectors.toList());
    }


    public static <E, V> List<V> filterSubList(Collection<E> collection, Function<E, List<V>> function, Predicate<V> ePredicate) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }
        List<V> allV = mergeSubList(collection, function);
        return allV.stream()
                .filter(ePredicate)
                .collect(Collectors.toList());
    }

    public static <E, V> List<V> mergeSubList(Collection<E> collection, Function<E, List<V>> function) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }
        List<V> allV = Lists.newArrayList();
        for (E e : collection) {
            List<V> values = function.apply(e);
            if (CollectionUtils.isNotEmpty(values)) {
                allV.addAll(values);
            }
        }
        return allV;
    }

    public static <E, V> List<V> convertAndFilterNull(Collection<E> collection, Function<E, V> ekFunction) {
        return convertAndFilterList(collection, ekFunction, Objects::nonNull);
    }

    public static <E, V> List<V> filterAndConvertList(Collection<E> collection, Predicate<E> ePredicate, Function<E, V> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }
        return collection.stream()
                .filter(ePredicate)
                .map(ekFunction)
                .collect(Collectors.toList());
    }

    public static <E, V> List<V> filterAndConvertList(Collection<E> collection, Predicate<E> ePredicate, Predicate<E> ePredicate1, Function<E, V> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }
        return collection.stream()
                .filter(ePredicate)
                .filter(ePredicate1)
                .map(ekFunction)
                .collect(Collectors.toList());
    }

    public static <E, V> List<V> filterAndConvertAndFilterList(Collection<E> collection, Predicate<E> ePredicate,
                                          Predicate<E> ePredicate1, Function<E, V> ekFunction, Predicate<V> ePredicate2) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }
        return collection.stream()
                .filter(ePredicate)
                .filter(ePredicate1)
                .map(ekFunction)
                .filter(ePredicate2)
                .collect(Collectors.toList());
    }

    public static <E, V> List<V> filterAndConvertList(Collection<E> collection, Predicate<E> ePredicate,
                                 Predicate<E> ePredicate1, Predicate<E> ePredicate2, Function<E, V> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }
        return collection.stream()
                .filter(ePredicate)
                .filter(ePredicate1)
                .filter(ePredicate2)
                .map(ekFunction)
                .collect(Collectors.toList());
    }

    public static <E, V> Set<V> filterNullAndConvert2Set(Collection<E> collection, Function<E, V> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Sets.newHashSet();
        }
        return collection.stream()
                .filter(Objects::nonNull)
                .map(ekFunction)
                .collect(Collectors.toSet());
    }

    public static <E, V> Set<V> filterAndConvert2Set(Collection<E> collection, Predicate<E> ePredicate, Function<E, V> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Sets.newHashSet();
        }
        return collection.stream()
                .filter(ePredicate)
                .map(ekFunction)
                .collect(Collectors.toSet());
    }

    public static <E, V> List<V> filterNullAndConvert(Collection<E> collection, Function<E, V> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }
        return collection.stream()
                .filter(Objects::nonNull)
                .map(ekFunction)
                .collect(Collectors.toList());
    }

    public static <E, V> Map<V, List<E>> filterAndGetGroupMap(Collection<E> collection, Predicate<E> ePredicate, Function<E, V> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Maps.newHashMap();
        }
        return collection.stream()
                .filter(ePredicate)
                .collect(Collectors.groupingBy(ekFunction));
    }

    public static <E, V, V1> Map<V, List<V1>> filterAndGetGroupMap(Collection<E> collection, Predicate<E> ePredicate, Function<E, V> ekFunction,
                                          Function<E, V1> ev1Function
    ) {
        if (CollectionUtils.isEmpty(collection)) {
            return Maps.newHashMap();
        }
        return collection.stream()
                .filter(ePredicate)
                .collect(Collectors.groupingBy(ekFunction, Collectors.mapping(ev1Function, Collectors.toList())));
    }

    public static <E, V, V1> Map<V, List<V1>> filterAndGetGroupMap(Collection<E> collection, Predicate<E> ePredicate1, Predicate<E> ePredicate2, Function<E, V> ekFunction,
                                          Function<E, V1> ev1Function
    ) {
        if (CollectionUtils.isEmpty(collection)) {
            return Maps.newHashMap();
        }
        return collection.stream()
                .filter(ePredicate1)
                .filter(ePredicate2)
                .collect(Collectors.groupingBy(ekFunction, Collectors.mapping(ev1Function, Collectors.toList())));
    }


    public static <E, V, V1> Map<V, V1> filterAndGetMap(Collection<E> collection, Predicate<E> ePredicate,
                               Function<E, V> ekFunction, Function<E, V1> ev1Function) {
        if (CollectionUtils.isEmpty(collection)) {
            return Maps.newHashMap();
        }
        return collection.parallelStream()
                .filter(ePredicate)
                .collect(Collectors.toMap(ekFunction, ev1Function, (a, b) -> a));
    }

    public static <K, V, V1> Map<K, List<V1>> convertMap(Map<K, List<V>> map, Function<V, V1> valueFunction) {
        return convertMap(map, k -> k, valueFunction);
    }

    public static <K, K1, V, V1> Map<K1, List<V1>> convertMap(Map<K, List<V>> map, Function<K, K1> keyFunction, Function<V, V1> valueFunction) {
        if (map == null || map.isEmpty()) {
            return Maps.newHashMap();
        }
        Map<K1, List<V1>> result = Maps.newHashMap();
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            result.put(keyFunction.apply(entry.getKey()), convertList(entry.getValue(), valueFunction));
        }
        return result;
    }

    public static <K, V, V1> Map<K, List<V1>> convertMapV2(Map<K, List<V>> map, Function<List<V>, List<V1>> valueFunction) {
        return convertMapV2(map, k -> k, valueFunction);
    }

    public static <K, K1, V, V1> Map<K1, List<V1>> convertMapV2(Map<K, List<V>> map, Function<K, K1> keyFunction, Function<List<V>, List<V1>> valuesFunction) {
        if (map == null || map.isEmpty()) {
            return Maps.newHashMap();
        }
        Map<K1, List<V1>> result = Maps.newHashMap();
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            result.put(keyFunction.apply(entry.getKey()), valuesFunction.apply(entry.getValue()));
        }
        return result;
    }

    public static <K, V, V1> Map<K, V1> convertMapV3(Map<K, V> map, Function<V, V1> valueFunction) {
        return convertMapV3(map, k -> k, valueFunction);
    }

    public static <K, K1, V, V1> Map<K1, V1> convertMapV3(Map<K, V> map, Function<K, K1> keyFunction, Function<V, V1> valuesFunction) {
        if (map == null || map.isEmpty()) {
            return Maps.newHashMap();
        }
        Map<K1, V1> result = Maps.newHashMap();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (Objects.nonNull(entry.getKey())) {
                result.put(keyFunction.apply(entry.getKey()), valuesFunction.apply(entry.getValue()));
            }
        }
        return result;
    }

    public static <K, E> List<K> convert2ListAndDistinct(Collection<E> collection, Function<E, K> ekFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }

        return collection.stream()
                .filter(Objects::nonNull)
                .map(ekFunction)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }


    public static <E, T> List<T> flatMapAndConvert2List(Collection<E> collection,
                                                        Function<E, Stream<T>> fmFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }

        return collection.stream()
                .flatMap(fmFunction)
                .collect(Collectors.toList());
    }

    public static <E, T> List<T> flatMapAndConvert2ListDistinct(Collection<E> collection,
                                                                Function<E, Stream<T>> fmFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return Lists.newArrayList();
        }

        return collection.stream()
                .flatMap(fmFunction)
                .collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());

    }


    public static <E, V> long convertAndFilterAndCount(Collection<E> collection, Function<E, V> ekFunction, Predicate<V> ePredicate) {
        if (CollectionUtils.isEmpty(collection)) {
            return Long.MIN_VALUE;
        }

        return collection.stream()
                .map(ekFunction)
                .filter(ePredicate)
                .count();
    }

    public static <E> Optional<E> findAny(Collection<E> collection, Predicate<E> ePredicate) {
        if (CollectionUtils.isEmpty(collection)) {
            return Optional.empty();
        }
        return collection.stream()
                .filter(ePredicate)
                .findAny();
    }

    public static <E> boolean anyMatch(Collection<E> collection, Predicate<E> ePredicate) {
        if (CollectionUtils.isEmpty(collection)) {
            return false;
        }
        return collection.stream()
                .anyMatch(ePredicate);
    }

    public static <E> void foreach(Collection<E> collection, Consumer<E> consumer) {
        if (CollectionUtils.isEmpty(collection)) {
            return;
        }
        collection.forEach(consumer);
    }

    public static <k, v> void foreach(Map<k, v> map, BiConsumer<k, v> consumer) {
        if (MapUtils.isEmpty(map)) {
            return;
        }
        map.forEach(consumer);
    }

    public static <E> void sort(List<E> list, Comparator<? super E> comparator) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        list.sort(comparator);
    }

    /**
     * 根据sortIdsList排序list
     * @param list
     * @param ekFunction
     * @param sortIdList
     * @param <E>
     * @param <K>
     * @return
     */
    public static <E,K> List<E> sortByList(List<E> list,Function<E, K> ekFunction, List<K> sortIdList) {
        if (CollectionUtils.isEmpty(list) || CollectionUtils.isEmpty(sortIdList)) {
            return list;
        }
        Map<K, List<E>> map = getGroupMap(list, ekFunction);
        List<E> sortList = Lists.newArrayList();
        sortIdList.forEach(k -> {
            if (map.get(k) != null){
                sortList.addAll(map.get(k));
            }
        });
        return sortList;
    }


    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return object -> seen.putIfAbsent(keyExtractor.apply(object), Boolean.TRUE) == null;
    }

    public static <E> Stream<E> getStream(Collection<E> collection) {
        if (CollectionUtils.isEmpty(collection)) {
            return CollectionUtils.EMPTY_COLLECTION.stream();
        }
        return collection.stream();
    }

}

