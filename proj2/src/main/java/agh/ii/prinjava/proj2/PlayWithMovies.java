package agh.ii.prinjava.proj2;

import agh.ii.prinjava.proj2.dal.ImdbTop250;
import agh.ii.prinjava.proj2.model.Movie;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface PlayWithMovies {

    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     */
    static Set<String> ex01(String director) {

        final Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies.orElseThrow().stream()
                .filter(movie1 -> movie1.directors().contains(director))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }

    /**
     * Returns the movies (only titles) in which an actor played
     */
    static Set<String> ex02(String actor) {

        final Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies.orElseThrow().stream()
                .filter(movie2 -> movie2.actors().contains(actor))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }



    /**
     * Returns the number of movies per director (as a map)
     */
    static Map<String, Long> ex03() {

        final Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies.orElseThrow().stream()
                .flatMap(movie3 -> movie3.directors().stream())
                .collect(Collectors.groupingBy(
                        director -> director,
                        Collectors.counting()));
    }

    /**
     * Returns the 10 directors with the most films on the list
     */
    static Map<String, Long> ex04() {

        final Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies.orElseThrow().stream()
                .flatMap(movie4 -> movie4.directors().stream())
                .collect(Collectors.groupingBy(
                        director -> director,
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oV, nV) -> oV,
                        LinkedHashMap::new
                ));
    }

    /**
     * Returns the movies (only titles) made by each of the 10 directors found in {@link PlayWithMovies#ex04 ex04}
     */
    static Map<String, Set<String>> ex05() {
        Map<String, Long> directorWithMostMovie = ex04();
        List<String> topTenDirectors = directorWithMostMovie.keySet().stream()
                .toList();

        return topTenDirectors.stream()
                .collect(
                        Collectors.toMap(
                                director -> director,
                                PlayWithMovies::ex01
                        ));


    }

    /**
     * Returns the number of movies per actor (as a map)
     */
    static Map<String, Long> ex06() {


        final Optional<List<Movie>> movies = ImdbTop250.movies();

        return movies.orElseThrow().stream()
                .flatMap(movie6 -> movie6.actors().stream())
                .collect(
                        Collectors.groupingBy(
                                actor -> actor,
                                Collectors.counting()
                        )
                );

    }

    /**
     * Returns the 9 actors with the most films on the list
     */
    static Map<String, Long> ex07() {

        final Optional<List<Movie>> movies = ImdbTop250.movies();

        return movies.orElseThrow().stream()
                .flatMap(movie1 -> movie1.actors().stream())
                .collect(Collectors.groupingBy(
                        actor -> actor,
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(9)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oV, nV2) -> oV,
                        LinkedHashMap::new
                ));
    }

    /**
     * Returns the movies (only titles) of each of the 9 actors from {@link PlayWithMovies#ex07 ex07}
     */
    static Map<String, Set<String>> ex08() {

        Map<String, Long> actorWithMostMovie = ex07();
        List<String> top9Actors = actorWithMostMovie.keySet().stream()
                .toList();

        return top9Actors.stream()
                .collect(
                        Collectors.toMap(
                                actor -> actor,
                                PlayWithMovies::ex02
                        ));
    }







    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    static Map<String, Long> ex09() {
        final Optional<List<Movie>> movies = ImdbTop250.movies();

        return  movies.orElseThrow().stream()
                .flatMap(movie -> movie.actors().stream().distinct().sorted()
                        .flatMap(a1 -> movie.actors().stream().distinct().sorted()
                                .filter(a2 -> a2.compareTo(a1) > 0)
                                .map(a2 -> a1 + ", " + a2)
                        )
                )
                .collect(
                        Collectors.groupingBy(
                                x -> x,
                                Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (v1, v2) -> v1,
                                LinkedHashMap::new));
    }




    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    static Map<String, Set<String>> ex10() {
        Map<String, Long> actorPairsCount = ex09();
        return actorPairsCount.keySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(actorPairsCount::get)))
                .collect(Collectors.toMap(
                        pair -> pair,
                        pair -> ImdbTop250.movies().stream()
                                .flatMap(List::stream)
                                .filter(movie -> movie.actors().containsAll(Arrays.asList(pair.split(", "))))
                                .map(Movie::title)
                                .collect(Collectors.toSet())
                ));
    }
}

