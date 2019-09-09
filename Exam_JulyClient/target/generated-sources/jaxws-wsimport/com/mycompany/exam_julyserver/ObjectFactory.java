
package com.mycompany.exam_julyserver;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.exam_julyserver package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllMoviesResponse_QNAME = new QName("http://exam_julyserver.mycompany.com/", "getAllMoviesResponse");
    private final static QName _SQLException_QNAME = new QName("http://exam_julyserver.mycompany.com/", "SQLException");
    private final static QName _GetMovieResponse_QNAME = new QName("http://exam_julyserver.mycompany.com/", "getMovieResponse");
    private final static QName _GetMovie_QNAME = new QName("http://exam_julyserver.mycompany.com/", "getMovie");
    private final static QName _GetAllMovies_QNAME = new QName("http://exam_julyserver.mycompany.com/", "getAllMovies");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.exam_julyserver
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMovieResponse }
     * 
     */
    public GetMovieResponse createGetMovieResponse() {
        return new GetMovieResponse();
    }

    /**
     * Create an instance of {@link GetAllMoviesResponse }
     * 
     */
    public GetAllMoviesResponse createGetAllMoviesResponse() {
        return new GetAllMoviesResponse();
    }

    /**
     * Create an instance of {@link SQLException }
     * 
     */
    public SQLException createSQLException() {
        return new SQLException();
    }

    /**
     * Create an instance of {@link GetAllMovies }
     * 
     */
    public GetAllMovies createGetAllMovies() {
        return new GetAllMovies();
    }

    /**
     * Create an instance of {@link GetMovie }
     * 
     */
    public GetMovie createGetMovie() {
        return new GetMovie();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllMoviesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exam_julyserver.mycompany.com/", name = "getAllMoviesResponse")
    public JAXBElement<GetAllMoviesResponse> createGetAllMoviesResponse(GetAllMoviesResponse value) {
        return new JAXBElement<GetAllMoviesResponse>(_GetAllMoviesResponse_QNAME, GetAllMoviesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SQLException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exam_julyserver.mycompany.com/", name = "SQLException")
    public JAXBElement<SQLException> createSQLException(SQLException value) {
        return new JAXBElement<SQLException>(_SQLException_QNAME, SQLException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exam_julyserver.mycompany.com/", name = "getMovieResponse")
    public JAXBElement<GetMovieResponse> createGetMovieResponse(GetMovieResponse value) {
        return new JAXBElement<GetMovieResponse>(_GetMovieResponse_QNAME, GetMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exam_julyserver.mycompany.com/", name = "getMovie")
    public JAXBElement<GetMovie> createGetMovie(GetMovie value) {
        return new JAXBElement<GetMovie>(_GetMovie_QNAME, GetMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllMovies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exam_julyserver.mycompany.com/", name = "getAllMovies")
    public JAXBElement<GetAllMovies> createGetAllMovies(GetAllMovies value) {
        return new JAXBElement<GetAllMovies>(_GetAllMovies_QNAME, GetAllMovies.class, null, value);
    }

}
