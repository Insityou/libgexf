/* 
 * File:   schemavalidator.h
 * Author: sebastien
 *
 * Created on 31 juillet 2009, 01:19
 */

#ifndef _SCHEMAVALIDATOR_H
#define	_SCHEMAVALIDATOR_H

#include <libxml/xmlreader.h>
#include <libxml/xmlschemas.h>
#include <string>

namespace libgexf {

class SchemaValidator {
public:
    SchemaValidator();
    SchemaValidator(const SchemaValidator& orig);
    virtual ~SchemaValidator();

    /*!
     *  \brief Validate an XML file based on an XML Schema
     *
     *  \param xml_file_pathname : path of the XML file to validate
     *  \param xml_schema_file_pathname : path of the XSD file
     *
     *  \return true if valid, false otherwise
     */
    static bool run(const std::string xml_file_pathname, const std::string xml_schema_file_pathname);
private:
    static void schemaErrorCallback(void*, const char* msg, xmlParserSeverities severity, xmlTextReaderLocatorPtr locator);
    static void schemaWarningCallback(void* callbackData, const char* msg, xmlParserSeverities severity, xmlTextReaderLocatorPtr locator);
    virtual void iAmAbstract() = 0;
};

} /* namespace libgexf */

#endif	/* _SCHEMAVALIDATOR_H */

