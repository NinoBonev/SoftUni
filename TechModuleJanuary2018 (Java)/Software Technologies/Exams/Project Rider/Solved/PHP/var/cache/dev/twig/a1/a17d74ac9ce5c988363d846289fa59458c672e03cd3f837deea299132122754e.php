<?php

/* @WebProfiler/Collector/exception.html.twig */
class __TwigTemplate_0acfe6e0d74ca654a1a4affc281db3f3a85b89e0dc74c98b09bfaf6fb7b9bf4c extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("@WebProfiler/Profiler/layout.html.twig", "@WebProfiler/Collector/exception.html.twig", 1);
        $this->blocks = array(
            'head' => array($this, 'block_head'),
            'menu' => array($this, 'block_menu'),
            'panel' => array($this, 'block_panel'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "@WebProfiler/Profiler/layout.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_4bbb771d7d096e0f3ddc049808970cf4cc78713ee0ac5a270a9d67eb250df39b = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_4bbb771d7d096e0f3ddc049808970cf4cc78713ee0ac5a270a9d67eb250df39b->enter($__internal_4bbb771d7d096e0f3ddc049808970cf4cc78713ee0ac5a270a9d67eb250df39b_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@WebProfiler/Collector/exception.html.twig"));

        $__internal_a9c981ea7d0c1a2660807b67a65df9f868053fb71856ade7c67b1274b06218c6 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_a9c981ea7d0c1a2660807b67a65df9f868053fb71856ade7c67b1274b06218c6->enter($__internal_a9c981ea7d0c1a2660807b67a65df9f868053fb71856ade7c67b1274b06218c6_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@WebProfiler/Collector/exception.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_4bbb771d7d096e0f3ddc049808970cf4cc78713ee0ac5a270a9d67eb250df39b->leave($__internal_4bbb771d7d096e0f3ddc049808970cf4cc78713ee0ac5a270a9d67eb250df39b_prof);

        
        $__internal_a9c981ea7d0c1a2660807b67a65df9f868053fb71856ade7c67b1274b06218c6->leave($__internal_a9c981ea7d0c1a2660807b67a65df9f868053fb71856ade7c67b1274b06218c6_prof);

    }

    // line 3
    public function block_head($context, array $blocks = array())
    {
        $__internal_85f73900b190413f0976ab57b77fffc07c3c2845dcc60feba7a4acc1208ae6a2 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_85f73900b190413f0976ab57b77fffc07c3c2845dcc60feba7a4acc1208ae6a2->enter($__internal_85f73900b190413f0976ab57b77fffc07c3c2845dcc60feba7a4acc1208ae6a2_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "head"));

        $__internal_f3a8368941d66533f529be691677edad785b57f65a04a626006582422c910e06 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_f3a8368941d66533f529be691677edad785b57f65a04a626006582422c910e06->enter($__internal_f3a8368941d66533f529be691677edad785b57f65a04a626006582422c910e06_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "head"));

        // line 4
        echo "    ";
        if ($this->getAttribute(($context["collector"] ?? $this->getContext($context, "collector")), "hasexception", array())) {
            // line 5
            echo "        <style>
            ";
            // line 6
            echo $this->env->getRuntime('Symfony\Bridge\Twig\Extension\HttpKernelRuntime')->renderFragment($this->env->getExtension('Symfony\Bridge\Twig\Extension\RoutingExtension')->getPath("_profiler_exception_css", array("token" => ($context["token"] ?? $this->getContext($context, "token")))));
            echo "
        </style>
    ";
        }
        // line 9
        echo "    ";
        $this->displayParentBlock("head", $context, $blocks);
        echo "
";
        
        $__internal_f3a8368941d66533f529be691677edad785b57f65a04a626006582422c910e06->leave($__internal_f3a8368941d66533f529be691677edad785b57f65a04a626006582422c910e06_prof);

        
        $__internal_85f73900b190413f0976ab57b77fffc07c3c2845dcc60feba7a4acc1208ae6a2->leave($__internal_85f73900b190413f0976ab57b77fffc07c3c2845dcc60feba7a4acc1208ae6a2_prof);

    }

    // line 12
    public function block_menu($context, array $blocks = array())
    {
        $__internal_34293eeff9b3ef8f0a426119800badd5a37ac5df4203d6d3b39b54f43eae89fb = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_34293eeff9b3ef8f0a426119800badd5a37ac5df4203d6d3b39b54f43eae89fb->enter($__internal_34293eeff9b3ef8f0a426119800badd5a37ac5df4203d6d3b39b54f43eae89fb_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "menu"));

        $__internal_536c0e429ece88a942776bc927e644ea79e5baebefd91f1128ebc5f1dafd9c83 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_536c0e429ece88a942776bc927e644ea79e5baebefd91f1128ebc5f1dafd9c83->enter($__internal_536c0e429ece88a942776bc927e644ea79e5baebefd91f1128ebc5f1dafd9c83_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "menu"));

        // line 13
        echo "    <span class=\"label ";
        echo (($this->getAttribute(($context["collector"] ?? $this->getContext($context, "collector")), "hasexception", array())) ? ("label-status-error") : ("disabled"));
        echo "\">
        <span class=\"icon\">";
        // line 14
        echo twig_include($this->env, $context, "@WebProfiler/Icon/exception.svg");
        echo "</span>
        <strong>Exception</strong>
        ";
        // line 16
        if ($this->getAttribute(($context["collector"] ?? $this->getContext($context, "collector")), "hasexception", array())) {
            // line 17
            echo "            <span class=\"count\">
                <span>1</span>
            </span>
        ";
        }
        // line 21
        echo "    </span>
";
        
        $__internal_536c0e429ece88a942776bc927e644ea79e5baebefd91f1128ebc5f1dafd9c83->leave($__internal_536c0e429ece88a942776bc927e644ea79e5baebefd91f1128ebc5f1dafd9c83_prof);

        
        $__internal_34293eeff9b3ef8f0a426119800badd5a37ac5df4203d6d3b39b54f43eae89fb->leave($__internal_34293eeff9b3ef8f0a426119800badd5a37ac5df4203d6d3b39b54f43eae89fb_prof);

    }

    // line 24
    public function block_panel($context, array $blocks = array())
    {
        $__internal_05e1ca230f4d7a01fab036e2e2926bfe470008a4221005ddf70432103a85b9f6 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_05e1ca230f4d7a01fab036e2e2926bfe470008a4221005ddf70432103a85b9f6->enter($__internal_05e1ca230f4d7a01fab036e2e2926bfe470008a4221005ddf70432103a85b9f6_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "panel"));

        $__internal_97955a5bf68722d7a74369cff8b7dfd3c52c2de208faddc93cdfae0d2b43ed8c = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_97955a5bf68722d7a74369cff8b7dfd3c52c2de208faddc93cdfae0d2b43ed8c->enter($__internal_97955a5bf68722d7a74369cff8b7dfd3c52c2de208faddc93cdfae0d2b43ed8c_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "panel"));

        // line 25
        echo "    <h2>Exceptions</h2>

    ";
        // line 27
        if ( !$this->getAttribute(($context["collector"] ?? $this->getContext($context, "collector")), "hasexception", array())) {
            // line 28
            echo "        <div class=\"empty\">
            <p>No exception was thrown and caught during the request.</p>
        </div>
    ";
        } else {
            // line 32
            echo "        <div class=\"sf-reset\">
            ";
            // line 33
            echo $this->env->getRuntime('Symfony\Bridge\Twig\Extension\HttpKernelRuntime')->renderFragment($this->env->getExtension('Symfony\Bridge\Twig\Extension\RoutingExtension')->getPath("_profiler_exception", array("token" => ($context["token"] ?? $this->getContext($context, "token")))));
            echo "
        </div>
    ";
        }
        
        $__internal_97955a5bf68722d7a74369cff8b7dfd3c52c2de208faddc93cdfae0d2b43ed8c->leave($__internal_97955a5bf68722d7a74369cff8b7dfd3c52c2de208faddc93cdfae0d2b43ed8c_prof);

        
        $__internal_05e1ca230f4d7a01fab036e2e2926bfe470008a4221005ddf70432103a85b9f6->leave($__internal_05e1ca230f4d7a01fab036e2e2926bfe470008a4221005ddf70432103a85b9f6_prof);

    }

    public function getTemplateName()
    {
        return "@WebProfiler/Collector/exception.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  138 => 33,  135 => 32,  129 => 28,  127 => 27,  123 => 25,  114 => 24,  103 => 21,  97 => 17,  95 => 16,  90 => 14,  85 => 13,  76 => 12,  63 => 9,  57 => 6,  54 => 5,  51 => 4,  42 => 3,  11 => 1,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("{% extends '@WebProfiler/Profiler/layout.html.twig' %}

{% block head %}
    {% if collector.hasexception %}
        <style>
            {{ render(path('_profiler_exception_css', { token: token })) }}
        </style>
    {% endif %}
    {{ parent() }}
{% endblock %}

{% block menu %}
    <span class=\"label {{ collector.hasexception ? 'label-status-error' : 'disabled' }}\">
        <span class=\"icon\">{{ include('@WebProfiler/Icon/exception.svg') }}</span>
        <strong>Exception</strong>
        {% if collector.hasexception %}
            <span class=\"count\">
                <span>1</span>
            </span>
        {% endif %}
    </span>
{% endblock %}

{% block panel %}
    <h2>Exceptions</h2>

    {% if not collector.hasexception %}
        <div class=\"empty\">
            <p>No exception was thrown and caught during the request.</p>
        </div>
    {% else %}
        <div class=\"sf-reset\">
            {{ render(path('_profiler_exception', { token: token })) }}
        </div>
    {% endif %}
{% endblock %}
", "@WebProfiler/Collector/exception.html.twig", "C:\\Users\\NinoB\\Desktop\\teting\\vendor\\symfony\\symfony\\src\\Symfony\\Bundle\\WebProfilerBundle\\Resources\\views\\Collector\\exception.html.twig");
    }
}
