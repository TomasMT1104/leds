package co.edu.umanizales.leds.model;

public class NodeDE {
        private Led data;
        private NodeDE next;
        private NodeDE previous;
        public  NodeDE (Led data)
        {
            this.data = data;
        }

    public Led getData() {
        return data;
    }

    public void setData(Led data) {
        this.data = data;
    }

    public NodeDE getNext() {
        return next;
    }

    public void setNext(NodeDE next) {
        this.next = next;
    }
}
