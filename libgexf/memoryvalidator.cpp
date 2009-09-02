/* 
 * File:   MemoryValidator.cpp
 * Author: sebastien
 * 
 * Created on 2 septembre 2009, 14:53
 */

#include "memoryvalidator.h"
#include "conv.h"
#include "nodeiter.h"

#include <cstdio>
#include <string>

namespace libgexf {

MemoryValidator::MemoryValidator() {
}

MemoryValidator::MemoryValidator(const MemoryValidator& orig) {
}

MemoryValidator::~MemoryValidator() {
}

//-----------------------------------------
bool MemoryValidator::run(const GEXF& gexf) {
//-----------------------------------------
    return ( checkNodeLabels(gexf) && checkAttValues(gexf) );
}

//-----------------------------------------
bool MemoryValidator::checkNodeLabels(const GEXF& gexf) {
//-----------------------------------------
bool r = true;

    /* check if each node has a label */
    NodeIter* it = gexf._graph.getNodes();
    while(it->hasNext()) {
        const t_id node_id = it->next();
        if( !gexf._data.hasLabel(node_id) )
            std::cerr << "No label for the node " << (std::string)node_id << std::endl;
    }

    return r;
}

//-----------------------------------------
bool MemoryValidator::checkAttValues(const GEXF& gexf) {
//-----------------------------------------
bool r = true;

    /* check if each attvalue has a value or a defaultvalue, and the type of each value */
    AttributeIter* it_attr = gexf._data.getNodeAttributeColumn();
    while(it_attr->hasNext()) {
        const t_id attr_id = it_attr->next();
        const std::string title = it_attr->currentTitle();
        const t_attr_type type = it_attr->currentType();
        const bool has_default = gexf._data.hasNodeAttributeDefault(attr_id);
        NodeIter* it_node = gexf._graph.getNodes();
        while(it_node->hasNext()) {
            const t_id node_id = it_node->next();
            const std::string value = gexf._data.getNodeAttribute(node_id, attr_id);
            if( value.empty() ) {
                if( !has_default ) {
                    r = false;
                    std::cerr << "A value is required for the attribute " << title << "(id=" << (std::string)attr_id << ") of the node " << (std::string)node_id << std::endl;
                }
            }
            else {
                r = r && checkAttValueType(gexf, value, type, node_id, attr_id, true);
            }
        }
    }
    it_attr = gexf._data.getEdgeAttributeColumn();
    while(it_attr->hasNext()) {
        const t_id attr_id = it_attr->next();
        const std::string title = it_attr->currentTitle();
        const t_attr_type type = it_attr->currentType();
        const bool has_default = gexf._data.hasEdgeAttributeDefault(attr_id);
        EdgeIter* it_edge = gexf._graph.getEdges();
        while(it_edge->hasNext()) {
            const t_id edge_id = it_edge->next();
            const std::string value = gexf._data.getNodeAttribute(edge_id, attr_id);
            if( value.empty() ) {
                if( !has_default ) {
                    r = false;
                    std::cerr << "A value is required for the attribute " << title << "(id=" << (std::string)attr_id << ") of the edge " << (std::string)edge_id << std::endl;
                }
            }
            else {
                r = r && checkAttValueType(gexf, value, type, edge_id, attr_id, false);
            }
        }
    }

    return r;
}

//-----------------------------------------
bool MemoryValidator::checkAttValueType(const GEXF& gexf, const std::string& value, const libgexf::t_attr_type type, const t_id elem_id, const t_id attr_id, const bool isNode) {
//-----------------------------------------
bool r = false;

    switch(type) {
        case INTEGER:
            r = Conv::isInteger(value);
            if( !r ) {
                const std::string elem = (isNode) ? "node" : "edge";
                std::cerr << "Attribute type error for the " << elem << " \"" << elem_id << "\": \"" << value << "\" should be an integer" << std::endl;
            }
            break;
        case DOUBLE:
            r = Conv::isDouble(value);
            if( !r ) {
                const std::string elem = (isNode) ? "node" : "edge";
                std::cerr << "Attribute type error for the " << elem << " \"" << elem_id << "\": \"" << value << "\" should be a double" << std::endl;
            }
            break;
        case FLOAT:
            r = Conv::isFloat(value);
            if( !r ) {
                const std::string elem = (isNode) ? "node" : "edge";
                std::cerr << "Attribute type error for the " << elem << " \"" << elem_id << "\": \"" << value << "\" should be a float" << std::endl;
            }
            break;
        case BOOLEAN:
            r = Conv::isBoolean(value);
            if( !r ) {
                const std::string elem = (isNode) ? "node" : "edge";
                std::cerr << "Attribute type error for the " << elem << " \"" << elem_id << "\": \"" << value << "\" should be a boolean (true|false)" << std::endl;
            }
            break;
        case LIST_STRING:
            if( isNode ) {
                r = gexf._data.isNodeAttributeOption(attr_id, value);
            }
            else {
                r = gexf._data.isEdgeAttributeOption(attr_id, value);
            }
            if( !r ) {
                const std::string elem = (isNode) ? "node" : "edge";
                std::cerr << "Attribute type error for the " << elem << " \"" << elem_id << "\": \"" << value << "\" does not exist in option \"" << attr_id << "\"" << std::endl;
            }
            break;
        default: // =STRING
            r = true;
            break;
    }

    return r;
}


}
